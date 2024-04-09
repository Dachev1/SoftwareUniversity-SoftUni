package christmasPastryShop.entities.cocktails.interfaces;

public class Hibernation extends BaseCocktail{
    private static final double PRICE = 4.50;
    public Hibernation(String name, int size, String brand) {
        super(name, size, PRICE, brand);
    }
}
