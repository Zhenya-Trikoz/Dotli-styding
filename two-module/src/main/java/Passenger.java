public class Passenger extends Person {

    private int distanceTripInMeter;

    public Passenger(String firstName, String lastName, double money, int distanceTripInMeter) {
        super(firstName, lastName, money);
        this.distanceTripInMeter = distanceTripInMeter;
    }

    public int getDistanceTripInMeter() {
        return distanceTripInMeter;
    }

    public void setDistanceTripInMeter(int distanceTripInMeter) {
        this.distanceTripInMeter = distanceTripInMeter;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "distanceTripInMeter=" + distanceTripInMeter +
                '}';
    }
}
