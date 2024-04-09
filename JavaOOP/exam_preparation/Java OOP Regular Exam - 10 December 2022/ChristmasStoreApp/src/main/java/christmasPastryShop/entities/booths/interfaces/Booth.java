package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

public interface Booth {
    int getBoothNumber();

    int getCapacity();

    boolean isReserved();

    double getPrice();
    void orderDelicacy(Delicacy delicacy);

    void orderCocktail(Cocktail cocktail);

    void reserve(int numberOfPeople);

    double getBill();

    void clear();

}
