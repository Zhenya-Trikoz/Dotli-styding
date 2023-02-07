public class Main {
    public static void main(String[] args) {
        Passenger passenger = new Passenger("Alan", "W", 200, 250);
        Car BWM = new Car("BWM", 140, 36.5, 12.3);
        Driver driver = new Driver("Bob", "Bober", 140, 2, 50, BWM);


        double priceTrip = Calc.CalculatePriceOfTheTrip(BWM.getPriceTrip(), driver.getPriceTrip(), BWM.getPriceFuel(), BWM.getUsingFuelOn100Km(), passenger.getDistanceTripInMeter());

        if (priceTrip <= passenger.getMoney()) {
            System.out.printf("У пасажира вистачає грошей: " + passenger.getMoney() + " вартість поїздки складає: %.2f \n", priceTrip);
            passenger.setMoney(passenger.getMoney() - priceTrip);
            driver.setMoney(driver.getMoney() + priceTrip);

            System.out.printf("Залишок грошей пасажира: %.2f\n", passenger.getMoney());
            System.out.printf("Гроші водія: %.2f\n", driver.getMoney());

        } else {
            System.out.printf("У пасажира не вистачає грошей: " + passenger.getMoney() + " вартість поїздки складає: %.2f \n", priceTrip);
        }
    }
}
