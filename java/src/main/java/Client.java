import java.util.Arrays;

public class Client {
    private String name;

    private Action[] action;

    private int[] massBuyAction;

    public Client(String name, Action[] action) {
        this.name = name;
        this.action = action;
        this.massBuyAction = new int[action.length];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action[] getAction() {
        return action;
    }

    public void setAction(Action[] action) {
        this.action = action;
    }

    public int[] getMassBuyAction() {
        return massBuyAction;
    }

    public void setMassBuyAction(int[] massBuyAction) {
        this.massBuyAction = massBuyAction;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", action=" + Arrays.toString(action) +
                '}';
    }
}
