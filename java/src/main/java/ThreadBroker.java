import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ThreadBroker extends Thread {
    public Client client;

    public ArrayList<Action> actions;
    private static boolean isActive;


    public ThreadBroker(String name, Client client, ArrayList<Action> actions) {
        super(name);
        this.client = client;
        this.actions = actions;
        isActive = true;
    }

    void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        while (isActive) {
            for (int i = 0; i < client.getAction().length; i++) {
                for (int a = 0; a < actions.size(); a++) {
                    if (client.getAction()[i].getName().equals(actions.get(a).getName())) {
                        synchronized (actions) {
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String formatDateTime = now.format(formatter);

                            if (actions.get(a).getPrice() <= client.getAction()[i].getPrice() && actions.get(a).getAmount() >= client.getAction()[i].getAmount()) {
                                System.out.println(formatDateTime + " Спроба купівлі акції " + actions.get(a).getName() + " для " + client.getName() + " успішна. Куплено " + client.getAction()[i].getAmount() + " акцій. ");
                                client.getMassBuyAction()[i] += client.getAction()[i].getAmount();

                                actions.get(a).setAmount(actions.get(a).getAmount() - client.getAction()[i].getAmount());
                            } else {
                                System.out.println(formatDateTime + " Спроба купівлі акції " + actions.get(a).getName() + " для " + client.getName() + " не успішна");
                            }
                        }
                    }
                }
            }
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }

        }
    }
}
