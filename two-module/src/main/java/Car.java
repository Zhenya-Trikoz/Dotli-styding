public class Car {

    private String mark;
    private double priceTrip;
    private double priceFuel;
    private double usingFuelOn100Km;
        public Car(String mark, double priceTrip, double priceFuel, double usingFuelOn100Km) {
        this.mark = mark;
        this.priceTrip = priceTrip;
        this.priceFuel = priceFuel;
        this.usingFuelOn100Km = usingFuelOn100Km;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public double getPriceTrip() {
        return priceTrip;
    }

    public void setPriceTrip(double priceTrip) {
        this.priceTrip = priceTrip;
    }

    public double getPriceFuel() {
        return priceFuel;
    }

    public void setPriceFuel(double priceFuel) {
        this.priceFuel = priceFuel;
    }

    public double getUsingFuelOn100Km() {
        return usingFuelOn100Km;
    }

    public void setUsingFuelOn100Km(double usingFuelOn100Km) {
        this.usingFuelOn100Km = usingFuelOn100Km;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", priceTrip=" + priceTrip +
                ", priceFuel=" + priceFuel +
                ", usingFuelOn100Km=" + usingFuelOn100Km +
                '}';
    }
}
