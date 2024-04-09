package polymorphism.lab.wild_farm.Food;

public abstract class Food {

    private Integer quantity;

    protected Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}