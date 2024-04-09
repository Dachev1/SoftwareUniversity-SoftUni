package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.price = 0;
    }
    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }
    @Override
    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }
    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }
    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
    @Override
    public void orderDelicacy(Delicacy delicacy) {
        this.delicacyOrders.add(delicacy);
    }

    @Override
    public void orderCocktail(Cocktail cocktail) {
        this.cocktailOrders.add(cocktail);
    }
    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        isReserved = true;
        this.price = this.pricePerPerson * numberOfPeople;
    }

    @Override
    public double getBill() {
        double bill = 0;
        bill += delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        bill += cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        bill += getPrice();
        return bill;
    }

    @Override
    public void clear() {
        this.cocktailOrders = new ArrayList<>();
        this.delicacyOrders = new ArrayList<>();
        this.numberOfPeople = 0;
        this.price = 0;
    }
}
