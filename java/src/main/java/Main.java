import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        Action action1 = new Action("AAPL", 100, 100);
        Action action2 = new Action("COKE", 1000, 350);
        Action action3 = new Action("IBM", 200, 120);

        ArrayList<Action> actionsList = new ArrayList<>();
        actionsList.add(action1);
        actionsList.add(action2);
        actionsList.add(action3);

        Client client1 = new Client("Alice", new Action[]{
                new Action("AAPL", 10, 100),
                new Action("COKE", 20, 390)});
        Client client2 = new Client("Bob", new Action[]{
                new Action("AAPL", 10, 140),

                new Action("IBM", 20, 135)});
        Client client3 = new Client("Charlie", new Action[]{

                new Action("COKE", 300, 370)
        });

        ArrayList<Client> clientsList = new ArrayList<>();
        clientsList.add(client1);
        clientsList.add(client2);
        clientsList.add(client3);

        ThreadExchange threadExchange = null;
        for (int i = 0; i < actionsList.size(); i++) {
            threadExchange = new ThreadExchange("ThreadExchange " + (i + 1), actionsList.get(i));
            threadExchange.start();
        }

        ThreadBroker threadBroker = null;
        for (int i = 0; i < clientsList.size(); i++) {
            threadBroker = new ThreadBroker("ThreadBroker " + (i + 1), clientsList.get(i), actionsList);
            threadBroker.start();
        }

        try {
            Thread.sleep(1000 * 60 * 10);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        threadExchange.disable();
        threadBroker.disable();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);

        System.out.println();
        System.out.println("FINAL");
        for (int i = 0; i < actionsList.size(); i++) {
            System.out.println(formatDateTime + " Акція " + actionsList.get(i).getName() + " кількість " + actionsList.get(i).getAmount() + " ціна " + actionsList.get(i).getPrice());
        }

        System.out.println();
        for (int i = 0; i < clientsList.size(); i++) {
            System.out.println(clientsList.get(i).getName());
            for (int a = 0; a < clientsList.get(i).getAction().length; a++) {
                System.out.println(formatDateTime + " Куплено акцій для " + clientsList.get(i).getAction()[a].getName() + " в кількості " + clientsList.get(i).getMassBuyAction()[a]);
            }
            System.out.println();

        }


    }
}
