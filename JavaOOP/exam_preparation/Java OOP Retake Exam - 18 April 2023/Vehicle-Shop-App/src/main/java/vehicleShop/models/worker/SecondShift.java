package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {
    private static final int INITIAL_STRENGTH = 70;

    public SecondShift(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void working() {
        int workerStrengthAfterWork = super.getStrength() - 5;
        if (workerStrengthAfterWork < 0) {
            workerStrengthAfterWork = 0;
        }
        this.setStrength(workerStrengthAfterWork);
    }
}
