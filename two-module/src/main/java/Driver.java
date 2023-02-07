public class Driver extends Person {
    private int experienceInYear;
    private double priceTrip;

    private Car car;

    public Driver(String firstName, String lastName, double money, int experienceInYear, double priceTrip, Car car) {
        super(firstName, lastName, money);
        this.experienceInYear = experienceInYear;
        this.priceTrip = priceTrip;
        this.car = car;
    }

    public int getExperienceInYear() {
        return experienceInYear;
    }

    public void setExperienceInYear(int experienceInYear) {
        this.experienceInYear = experienceInYear;
    }

    public double getPriceTrip() {
        return priceTrip;
    }

    public void setPriceTrip(double priceTrip) {
        this.priceTrip = priceTrip;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }



}
