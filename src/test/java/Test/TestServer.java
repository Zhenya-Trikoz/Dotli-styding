package Test;

import client.ClientSomething;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import server.Server;
import server.ServerListSocket;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestServer {
    @Test
    @Order(1)
    public void newClient() throws InterruptedException {
        Server server = new Server();

        Runnable r = () -> {
            System.out.println("Start Server");
            server.startServer();
        };
        Thread myThread = new Thread(r, "MyThread");
        myThread.start();

        String newClient = "ClientOne"; // Додайте \n після TestName
        InputStream mockInputStream = new ByteArrayInputStream(newClient.getBytes());
        System.setIn(mockInputStream);

        ClientSomething clientSomething = new ClientSomething("localhost", 8080);

        Thread.sleep(100);
        assertTrue(Server.listSockets.size() > 0, "Немає активних з'єднань");
        System.out.println("Було створенно нове з'єднання на сервері");
    }

    @Test
    @Order(2)
    public void verificationNameClient() throws InterruptedException {
        String newClient = "ClientTwo"; // Додайте \n після TestName
        InputStream mockInputStream = new ByteArrayInputStream(newClient.getBytes());
        System.setIn(mockInputStream);

        ClientSomething clientSomething = new ClientSomething("localhost", 8080);

        Thread.sleep(100);
        String nameClient = null;
        for (ServerListSocket socket : Server.listSockets) {
            if (clientSomething.getName().equals(socket.getNameClient())) {
                nameClient = socket.getNameClient();
            }
        }
        assertEquals(newClient, nameClient, "Клієнта із ім'ям " + newClient + " немає");
        System.out.println("Користувача за ім'ям " + newClient + " було знайдено на сервері");
    }

    @Test
    @Order(3)
    public void removeClient() throws InterruptedException {
        int numberSockets = Server.listSockets.size();
        System.out.println("Кількість активних з'єднань: " + numberSockets);
        String newClient = "ClientRemove\nclose";
        InputStream mockInputStream = new ByteArrayInputStream(newClient.getBytes());
        System.setIn(mockInputStream);

        ClientSomething clientSomething = new ClientSomething("localhost", 8080);

        Thread.sleep(100);
        assertEquals(numberSockets, Server.listSockets.size());
        System.out.println("Кількість активниз з'єднань дорівнює " + Server.listSockets.size() + " отже відключення користувача від сервера було успішним");
    }

    @Test
    @Order(4)
    public void sendMessage() throws InterruptedException {
        Server.listSockets.clear();
        Thread.sleep(100);

        String clientReadMessage = "ClientRead";
        InputStream mockInputStreamRead = new ByteArrayInputStream(clientReadMessage.getBytes());
        System.setIn(mockInputStreamRead);

        ClientSomething clientRead = new ClientSomething("localhost", 8080);

        Thread.sleep(100);

        String clientSendMessage = "ClientWriteMessage\nHello Word";
        InputStream mockInputStreamSend = new ByteArrayInputStream(clientSendMessage.getBytes());
        System.setIn(mockInputStreamSend);

        ClientSomething clientSend = new ClientSomething("localhost", 8080);
        Thread.sleep(100);

        assertEquals(clientSend.getStrWrite(), clientRead.getStrRead(), "Повідомлення не співпадають");
        System.out.println("Користувач " + clientSend.getName() + " успішно відправив відправив користувачу " + clientRead.getName() + " повідомлення: " + clientRead.getStrRead());


    }

}

