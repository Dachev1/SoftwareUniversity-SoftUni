package football.entities.player.ArtificialTurf;

import football.entities.player.BasePlayer;

public class Women extends BasePlayer {
    private static final double INITIAL_KILOGRAMS = 60.00;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        super.setStrength(super.getStrength() + 115);
    }
}
