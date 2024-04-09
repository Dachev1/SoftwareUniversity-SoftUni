package robotService.entities.robot.mainService;

import robotService.entities.robot.BaseRobot;

public class MaleRobot extends BaseRobot {
    private static final int INITIAL_KILOGRAMS = 9;
    public MaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 3);
    }
}
