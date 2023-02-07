public class Calc {

    public static double METER_IN_ONE_KILOMETER = 1000.0;

    public static double CalculatePriceOfTheTrip(double priceTripCar, double priceTripDriver, double priceFuel, double usingFuelOn100Km, int distanceInMeter) {
        double usingFuelOn1Km = usingFuelOn100Km / 100;

        double usingFuel = usingFuelOn1Km * (distanceInMeter / METER_IN_ONE_KILOMETER);

        return priceTripCar + priceTripDriver + (usingFuel * priceFuel);
    }
}
