package handball.entities.team.Outdoor;

import handball.entities.team.BaseTeam;

public class Bulgaria extends BaseTeam {
    private static final int INCREASES = 115;
    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        super.setAdvantage(super.getAdvantage() + INCREASES);
    }
}
