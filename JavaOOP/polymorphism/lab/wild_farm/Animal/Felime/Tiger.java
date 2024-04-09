package polymorphism.lab.wild_farm.Animal.Felime;

import polymorphism.lab.wild_farm.Food.Food;

public class Tiger extends Felime {
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.printf("ROAAR!!!%n");
    }
    @Override
    public boolean canEatFood(Food food) {
        return food.getClass().getSimpleName().equals("Meat");
    }
}