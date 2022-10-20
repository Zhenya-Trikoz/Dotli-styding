import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {


    public static void main(String[] args) {

        Action action1 = new Action("AAPL", 100, 141);
        Action action2 = new Action("COKE", 1000, 387);
        Action action3 = new Action("IBM", 200, 137);

        Action[] actions = new Action[3];
        actions[0] = action1;
        actions[1] = action2;
        actions[2] = action3;

        Client client1 = new Client("Alice", new Action[]{
                new Action("AAPL", 10, 100),
                new Action("COKE", 20, 390)});
        Client client2 = new Client("Bob", new Action[]{
                new Action("AAPL", 10, 140),

                new Action("IBM", 20, 135)});
        Client client3 = new Client("Charlie", new Action[]{

                new Action("COKE", 300, 370)
        });

        ThreadExchange threadExchange1 = new ThreadExchange("Thread1", action1);
        ThreadExchange threadExchange2 = new ThreadExchange("Thread2", action2);
        ThreadExchange threadExchange3 = new ThreadExchange("Thread3", action3);

        threadExchange1.start();
        threadExchange2.start();
        threadExchange3.start();

        ThreadBroker threadBroker1 = new ThreadBroker("Thread1Broke", client1, actions);
        ThreadBroker threadBroker2 = new ThreadBroker("Thread2Broke", client2, actions);
        ThreadBroker threadBroker3 = new ThreadBroker("Thread3Broke", client3, actions);

        threadBroker1.start();
        threadBroker2.start();
        threadBroker3.start();


        try {
            Thread.sleep(1000 * 60 * 5);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        threadExchange1.disable();
        threadExchange2.disable();
        threadExchange3.disable();
        threadBroker1.disable();
        threadBroker2.disable();
        threadBroker3.disable();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);

        System.out.println();
        System.out.println("FINAL");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(formatDateTime + " Акція " + actions[i].getName() + " кількість " + actions[i].getAmount() + " ціна " + actions[i].getPrice());
        }

        System.out.println();
        System.out.println(client1.getName());
        for (int i = 0; i < client1.getAction().length; i++) {
            System.out.println(formatDateTime + " Куплено акцій для " + client1.getAction()[i].getName() + " в кількості " + client1.getMassBuyAction()[i]);
        }

        System.out.println();
        System.out.println(client2.getName());
        for (int i = 0; i < client2.getAction().length; i++) {
            System.out.println(formatDateTime + " Куплено акцій для " + client2.getAction()[i].getName() + " в кількості " + client2.getMassBuyAction()[i]);
        }

        System.out.println();
        System.out.println(client3.getName());
        for (int i = 0; i < client3.getAction().length; i++) {
            System.out.println(formatDateTime + " Куплено акцій для " + client3.getAction()[i].getName() + " в кількості " + client3.getMassBuyAction()[i]);
        }

    }
}
