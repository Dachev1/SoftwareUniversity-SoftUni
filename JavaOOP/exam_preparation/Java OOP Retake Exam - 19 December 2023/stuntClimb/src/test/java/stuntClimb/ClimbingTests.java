package stuntClimb;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClimbingTests {
    private Climbing climbing;
    private RockClimber climber;

    @Before
    public void setUp() {
        this.climbing = new Climbing("MountainAdventure", 5);
        this.climber = new RockClimber("Ivan", 120);
    }

    @Test
    public void constructor_ShouldSetSuccessfullyValues() {

        String expectedName = "MountainAdventure";
        int expectedCapacity = 5;

        String actualName = this.climbing.getName();
        int actualCapacity = this.climbing.getCapacity();

        Assert.assertEquals(expectedCapacity, actualCapacity);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = NullPointerException.class)
    public void constructor_ShouldThrowArgumentNullExceptionForInvalidName() {

        new Climbing(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_ShouldThrowArgumentExceptionForInvalidCapacity() {

        new Climbing("MountainAdventure", -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethod_ShouldThrowsExceptionForInvalidCapacity() {
        Climbing pirin = new Climbing("Pirin" , 0);
        pirin.addRockClimber(this.climber);
    }

    @Test
    public void removeMethod_ShouldReturnTrueIfDiverIsFound() {

        Climbing vitosha = new Climbing("Vitosha" , 2);
        vitosha.addRockClimber(this.climber);

        boolean isRemove = vitosha.removeRockClimber("Ivan");

        Assert.assertTrue(isRemove);
    }

    @Test
    public void getCountMethod_ShouldReturnRightDiversCount() {

        this.climbing.addRockClimber(this.climber);
        Assert.assertEquals(1, this.climbing.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addClimberMethod_ShouldThrowArgumentExceptionForExistingClimber() {

        this.climbing.addRockClimber(this.climber);
        this.climbing.addRockClimber(this.climber);
    }
    @Test
    public void getStrength_ShouldReturnClimbersStrengthValue() {
        Assert.assertEquals(120, climber.getStrength(), 0.1);
    }


}
