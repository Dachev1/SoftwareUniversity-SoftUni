package robotService.entities.robot.secondaryService;

import robotService.entities.robot.BaseRobot;

public class FemaleRobot extends BaseRobot {
    private static final int INITIAL_KILOGRAMS = 7;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 1);
    }
}
