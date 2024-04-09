package magicGame.models.magicians.magicianTypes;

import magicGame.models.magicians.MagicianImpl;
import magicGame.models.magics.Magic;
import magicGame.models.magics.MagicImpl;

public class Wizard extends MagicianImpl {
    public Wizard(String username, int health, int protection, Magic magic) {
        super(username, health, protection, magic);
    }
}
