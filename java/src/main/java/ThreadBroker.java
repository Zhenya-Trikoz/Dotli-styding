import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ThreadBroker extends Thread {
    public Client client;

    public Action[] actions;
    private boolean isActive;


    public ThreadBroker(String name, Client client, Action[] actions) {
        super(name);
        this.client = client;
        this.actions = actions;
        this.isActive = true;
    }

    void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        while (isActive) {
            for (int i = 0; i < client.getAction().length; i++) {
                for (int a = 0; a < actions.length; a++) {
                    if (client.getAction()[i].getName().equals(actions[a].getName())) {
                        synchronized (actions) {
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String formatDateTime = now.format(formatter);

                            if (actions[a].getPrice() <= client.getAction()[i].getPrice() && actions[a].getAmount() > 0) {
                                System.out.println(formatDateTime + " Спроба купівлі акції " + actions[a].getName() + " для " + client.getName() + " успішна. Куплено " + client.getAction()[i].getAmount() + " акцій. ");
                                client.getMassBuyAction()[i] += client.getAction()[i].getAmount();

                                actions[a].setAmount(actions[a].getAmount() - client.getAction()[i].getAmount());
                            } else {
                                System.out.println(formatDateTime + " Спроба купівлі акції " + actions[a].getName() + " для " + client.getName() + " не успішна");
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
