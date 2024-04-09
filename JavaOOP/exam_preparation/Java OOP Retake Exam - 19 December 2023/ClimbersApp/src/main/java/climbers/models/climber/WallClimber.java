package climbers.models.climber;

public class WallClimber extends BaseClimber {
    private static final int INITIAL_UNITS_OF_STRENGTH = 90;
    private static final int REMOVE_STRENGTH_AFTER_CLIMB = 30;

    public WallClimber(String name) {
        super(name, INITIAL_UNITS_OF_STRENGTH);
    }
    @Override
    public void climb() {
        double decreasedStrength = super.getStrength() - REMOVE_STRENGTH_AFTER_CLIMB;
        if (decreasedStrength < 0) {
            decreasedStrength = 0;
        }
        super.setStrength(decreasedStrength);
    }
}
