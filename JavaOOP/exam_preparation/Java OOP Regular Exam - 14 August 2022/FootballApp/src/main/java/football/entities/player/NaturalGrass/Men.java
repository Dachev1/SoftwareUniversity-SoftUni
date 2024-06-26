package football.entities.player.NaturalGrass;

import football.entities.player.BasePlayer;

public class Men extends BasePlayer {
    private static final double INITIAL_KILOGRAMS = 85.50;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        super.setStrength(super.getStrength() + 145);
    }
}
