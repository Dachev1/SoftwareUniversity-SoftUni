package football.entities.field.types;

import football.entities.field.BaseField;
import football.entities.field.Field;

public class ArtificialTurf extends BaseField {
    private static final int INITIAL_CAPACITY = 150;

    public ArtificialTurf(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
