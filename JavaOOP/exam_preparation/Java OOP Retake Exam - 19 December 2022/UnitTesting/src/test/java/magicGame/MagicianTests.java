package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.spec.ECField;

public class MagicianTests {
    // MAGICIAN
    private static final String INITIAL_USERNAME = "Ivan";
    private static final int INITIAL_HEALTH = 5;
    private static final int ZERO = 0;


    // MAGIC
    private static final String INITIAL_NAME = "Fire";
    private static final int INITIAL_BULLETS = 2;
    private Magician magician;
    private Magic magic;

    @Before
    public void setUp() {
        this.magician = new Magician(INITIAL_USERNAME, INITIAL_HEALTH);
        this.magic = new Magic(INITIAL_NAME, INITIAL_BULLETS);
    }

    @Test
    public void test_Constructor_Should_Create_Correct_Objects() {
        String actualUsername = this.magician.getUsername();
        int actualHealth = this.magician.getHealth();

        String actualName = this.magic.getName();
        int actualBullets = this.magic.getBullets();

        Assert.assertEquals(INITIAL_USERNAME, actualUsername);
        Assert.assertEquals(INITIAL_HEALTH, actualHealth);
        Assert.assertEquals(INITIAL_NAME, actualName);
        Assert.assertEquals(INITIAL_BULLETS, actualBullets);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_Should_Throw_When_Username_Is_Null() {
        this.magician = new Magician(null, INITIAL_HEALTH);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_Should_Throw_When_Username_Is_Empty() {
        this.magician = new Magician(" ", INITIAL_HEALTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_Should_Throw_When_Health_Is_Below_Zero() {
        this.magician = new Magician(INITIAL_USERNAME, -1);
    }

    @Test(expected = IllegalStateException.class)
    public void test_takeDamage_Should_Throw_When_Health_Is_Zero() {
        this.magician = new Magician(INITIAL_USERNAME, ZERO);
        this.magician.takeDamage(5);
    }

    @Test
    public void test_takeDamage_Should_Decrease_Health_Correctly() {
        this.magician.takeDamage(1);
        Assert.assertEquals(4, this.magician.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void test_addMagic_Should_Throw_When_Magic_Is_Null() {
        this.magician.addMagic(null);
    }

    @Test
    public void test_addMagic_Should_Add_Magic() {
        this.magician.addMagic(this.magic);
        Assert.assertEquals(1,this.magician.getMagics().size());
    }

    @Test
    public void test_removeMagic_Should_Remove_Magic() {
        this.magician.addMagic(this.magic);
        this.magician.removeMagic(this.magic);
        Assert.assertEquals(0,this.magician.getMagics().size());
    }

    @Test
    public void test_getMagic_Should_Return_Null() {
        this.magician.addMagic(this.magic);
        Assert.assertEquals(null, this.magician.getMagic(INITIAL_USERNAME));
    }

    @Test
    public void test_getMagic_Should_Return_Magic() {
        this.magician.addMagic(this.magic);
        Assert.assertEquals(this.magic, this.magician.getMagic(this.magic.getName()));
    }
}
