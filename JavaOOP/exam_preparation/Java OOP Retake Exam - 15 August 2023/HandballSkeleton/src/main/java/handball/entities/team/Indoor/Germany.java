package handball.entities.team.Indoor;

import handball.entities.team.BaseTeam;

public class Germany extends BaseTeam {
    private static final int INCREASES = 145;
    public Germany(String name, String country, int advantage) {
        super(name, country, advantage);
    }
    @Override
    public void play() {
        super.setAdvantage(super.getAdvantage() + INCREASES);
    }
}
