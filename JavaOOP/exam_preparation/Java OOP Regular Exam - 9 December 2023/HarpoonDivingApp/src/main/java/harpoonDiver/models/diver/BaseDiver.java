package harpoonDiver.models.diver;

import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;

import java.sql.Driver;

import static harpoonDiver.common.ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY;
import static harpoonDiver.common.ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseDiver implements Diver {
    private static final int DEFAULT_OXYGEN_CONSUMPTION = 30;
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.seaCatch = new BaseSeaCatch();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }
    @Override
    public boolean canDive() {
        return this.oxygen > 0;
    }
    @Override
    public void shoot() {
        this.oxygen = Math.max(0 , this.oxygen - DEFAULT_OXYGEN_CONSUMPTION);
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }
    @Override
    public SeaCatch getSeaCatch() {
        return this.seaCatch;
    }

}
