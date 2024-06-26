package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import static goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer {
    private String name;
    private double energy;
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }
    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public boolean canDig() {
        return this.getEnergy() > 0;
    }
    @Override
    public void dig() {
        double energyAfterDig = this.getEnergy() - 15;
        if (energyAfterDig < 0) {
            energyAfterDig = 0;
        }
        this.setEnergy(energyAfterDig);
    }
}
