package magicGame.models.magics.magicTypes;

import magicGame.models.magics.MagicImpl;

public class RedMagic extends MagicImpl {
    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < 1) {
            return 0;
        }
        super.setBulletsCount(super.getBulletsCount() - 1);
        return 1;
    }
}
