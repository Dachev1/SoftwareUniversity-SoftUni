package restaurant.models.waiter;
public class HalfTimeWaiter  extends BaseWaiter{
    private static final int INITIAL_UNITS_OF_EFFICIENCY = 4;
    private static final int DECREASED_EFFICIENCY_BY_TWO_AFTER_WORK = 2;

    public HalfTimeWaiter(String name) {
        super(name, INITIAL_UNITS_OF_EFFICIENCY);
    }
    @Override
    public void work() {
        int decreasedEfficiency = super.getEfficiency() - DECREASED_EFFICIENCY_BY_TWO_AFTER_WORK;
        if (decreasedEfficiency < 0) {
            decreasedEfficiency = 0;
        }
        super.setEfficiency(decreasedEfficiency);
    }
}
