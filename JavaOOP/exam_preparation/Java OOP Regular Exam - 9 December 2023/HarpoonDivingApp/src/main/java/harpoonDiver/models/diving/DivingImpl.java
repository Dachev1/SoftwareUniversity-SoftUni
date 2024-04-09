package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving{
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        Collection<String> creatures = divingSite.getSeaCreatures();

        for (Diver diver : divers) {
            while (diver.canDive() && creatures.iterator().hasNext()) {
                diver.shoot();

                String currentCreature = creatures.iterator().next();
                diver.getSeaCatch().getSeaCreatures().add(currentCreature);
                creatures.remove(currentCreature);
            }
        }
    }
}
