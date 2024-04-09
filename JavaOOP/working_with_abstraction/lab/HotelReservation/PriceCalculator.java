package working_with_abstraction.lab.HotelReservation;

public class PriceCalculator {
    public static double calculatePrice(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        int multiplier = season.getMultiplier();
        double discountMultiplier = discount.getDiscount() / 100.0;
        double priceBeforeDiscount = numberOfDays * pricePerDay * multiplier;
        double discountedAmount = priceBeforeDiscount * discountMultiplier;
        return priceBeforeDiscount - discountedAmount;
    }
}
