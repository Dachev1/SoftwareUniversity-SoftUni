package polymorphism.lab.wild_farm.Animal.Felime;

import polymorphism.lab.wild_farm.Animal.Mammal.Mammal;

public abstract class Felime extends Mammal {
    protected Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
}