package ExamPreparation.August_9_2023.vendingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < this.buttonCapacity) {
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        for (Drink drink : this.drinks) {
            if (drink.getName().equals(name)) {
                this.drinks.remove(drink);
                return true;
            }
        }
        return false;
    }

    public Drink getLongest() {
        Drink drink = null;
        int biggestVolume = Integer.MIN_VALUE;

        for (Drink currentDrink : this.drinks) {
            if (currentDrink.getVolume() > biggestVolume) {
                drink = currentDrink;
                biggestVolume = currentDrink.getVolume();
            }
        }

        return drink;
    }

    public Drink getCheapest() {
        Drink drink = null;
        BigDecimal smallestPrice = new BigDecimal(Integer.MAX_VALUE);

        for (Drink drink1 : this.drinks) {
            if (drink1.getPrice().compareTo(smallestPrice) < 0) {
                drink = drink1;
                smallestPrice = new BigDecimal(String.valueOf(drink1.getPrice()));
            }
        }

        return drink;
    }

    public String buyDrink(String name) {
        Drink purchasedDrink = null;
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                purchasedDrink = drink;
            }
        }

        assert purchasedDrink != null;
        return purchasedDrink.toString();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drinks available:").append("\n");

        drinks.forEach(drink -> sb.append(drink).append("\n"));

        return sb.toString();
    }
}
