package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static final int PORT = 8080;
    public static LinkedList<ServerListSocket> listSockets = new LinkedList<>();

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }

    public void startServer() {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                Socket socket = server.accept();
                try {
                    ServerListSocket serverListSocket = new ServerListSocket(socket);
                    listSockets.add(serverListSocket);
                } catch (IOException e) {
                    socket.close();
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

