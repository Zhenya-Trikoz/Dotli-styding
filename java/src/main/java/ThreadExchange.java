import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ThreadExchange extends Thread {
    public Action action;
    private static boolean isActive;


    public ThreadExchange(String name, Action action) {
        super(name);
        this.action = action;
        isActive = true;
    }

    void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        while (isActive) {
            double priceAction;
            synchronized (action) {
                priceAction = action.getPrice();
            }
            double percentage = priceAction * 0.03;
            double leftBorder = priceAction - percentage;
            double rightBorder = priceAction + percentage;

            double price = Math.ceil((Math.random() * (rightBorder - leftBorder) + leftBorder) * Math.pow(10, 2)) / Math.pow(10, 2);
            synchronized (action) {
                action.setPrice(price);
            }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = now.format(formatter);

            System.out.println(formatDateTime + " Ціна акції компанії " + action.getName() + " змінилась. Поточна ціна: " + price);
            try {
                Thread.sleep(1000 * 30);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }

    }
}
