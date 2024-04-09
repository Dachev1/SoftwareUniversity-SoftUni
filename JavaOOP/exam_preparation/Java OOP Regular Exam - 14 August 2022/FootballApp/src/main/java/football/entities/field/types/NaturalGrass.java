package football.entities.field.types;

import football.entities.field.BaseField;

public class NaturalGrass extends BaseField {
    private static final int INITIAL_CAPACITY = 250;

    public NaturalGrass(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
