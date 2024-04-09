package restaurant.models.waiter;
public class FullTimeWaiter extends BaseWaiter{
private static final int INITIAL_UNITS_OF_EFFICIENCY = 8;
    private static final int DECREASED_EFFICIENCY_BY_ONE_AFTER_WORK = 1;

    public FullTimeWaiter(String name) {
        super(name, INITIAL_UNITS_OF_EFFICIENCY);
    }

    @Override
    public void work() {
        int decreasedEfficiency = super.getEfficiency() - DECREASED_EFFICIENCY_BY_ONE_AFTER_WORK;
        if (decreasedEfficiency < 0) {
            decreasedEfficiency = 0;
        }
        super.setEfficiency(decreasedEfficiency);
    }
}
