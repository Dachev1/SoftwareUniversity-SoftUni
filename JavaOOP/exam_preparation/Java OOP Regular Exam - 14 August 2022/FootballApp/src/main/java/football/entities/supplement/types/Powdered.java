package football.entities.supplement.types;

import football.entities.supplement.BaseSupplement;

public class Powdered extends BaseSupplement {
    private static final int INITIAL_ENERGY = 120;
    private static final double INITIAL_PRICE = 15;
    public Powdered() {
        super(INITIAL_ENERGY, INITIAL_PRICE);
    }
}
