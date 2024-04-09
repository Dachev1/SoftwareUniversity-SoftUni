package vehicleShop.models.tool;

import static vehicleShop.common.ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO;

public class ToolImpl implements Tool {
    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void decreasesPower() {
        int toolPowerAfterUse = this.power - 5;
        if (toolPowerAfterUse < 0) {
            toolPowerAfterUse = 0;
        }
        this.setPower(toolPowerAfterUse);
    }

    @Override
    public boolean isUnfit() {
        return this.power == 0;
    }
}
