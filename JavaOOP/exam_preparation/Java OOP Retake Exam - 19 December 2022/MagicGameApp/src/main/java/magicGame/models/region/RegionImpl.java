package magicGame.models.region;

import magicGame.models.magicians.Magician;
import magicGame.models.magicians.magicianTypes.Wizard;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    private static final int REQUIRED_BULLETS_FOR_WIZARD_TO_FIRE = 1;
    private static final int REQUIRED_BULLETS_FOR_BLACK_WIDOW_TO_FIRE = 10;
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = magicians.stream()
                .filter(magician -> "Wizard".equals(magician.getClass().getSimpleName()))
                .collect(Collectors.toList());
        List<Magician> blackWidows = magicians.stream()
                .filter(magician -> "BlackWidow".equals(magician.getClass().getSimpleName()))
                .collect(Collectors.toList());

        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {
            Magician currentWizard = wizards.get(0);
            Magician currentBlackWidow = blackWidows.get(0);

            if (currentWizard.getMagic().getBulletsCount() >= REQUIRED_BULLETS_FOR_WIZARD_TO_FIRE) {
                currentBlackWidow.takeDamage(currentWizard.getMagic().fire());
                if (!currentBlackWidow.isAlive()) {
                    blackWidows.remove(0);
                    continue;
                }
            }

            if (currentBlackWidow.getMagic().getBulletsCount() >= REQUIRED_BULLETS_FOR_BLACK_WIDOW_TO_FIRE) {
                currentWizard.takeDamage(currentBlackWidow.getMagic().fire());
                if (!currentWizard.isAlive()) {
                    blackWidows.remove(0);
                }
            }
        }

        if (wizards.isEmpty()) {
            return "Black widows win!";
        } else {
            return "Wizards win!";
        }
    }
}
