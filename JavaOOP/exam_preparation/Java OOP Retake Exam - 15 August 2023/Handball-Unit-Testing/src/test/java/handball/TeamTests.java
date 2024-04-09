package handball;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTests {

    private Team expected;

    @Before
    public void setUp() {
        this.expected = new Team("Vratsa", 2);
    }

    @Test
    public void testConstructor1() {
        assertEquals(expected.getName(), "Vratsa");
        assertEquals(expected.getPosition(), 2);
        assertEquals(expected.getCount(), 0);
    }

    @Test(expected = NullPointerException.class)
    public void testSetName() {
        this.expected = new Team("", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPosition() {
        this.expected = new Team("Vratsa", -1);
    }

    @Test
    public void testGetName() {
        assertEquals("Vratsa", this.expected.getName());
    }

    @Test
    public void testGetPosition() {
        assertEquals(2, this.expected.getPosition());
    }

    @Test
    public void testGetCount() {
        assertEquals(0, this.expected.getCount());
    }

    @Test
    public void testAddPlayer() {
        assertEquals(0, this.expected.getCount());
        this.expected.add(new HandballPlayer("Ivan"));
        assertEquals(1, this.expected.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayer1() {
        HandballPlayer one = new HandballPlayer("Gencho");
        HandballPlayer two = new HandballPlayer("Ivanov");
        HandballPlayer three = new HandballPlayer("Ivanovsss");
        this.expected.add(one);
        this.expected.add(two);
        this.expected.add(three);
    }

    @Test
    public void testRemovePlayer() {
        HandballPlayer one = new HandballPlayer("Ivanov");
        HandballPlayer two = new HandballPlayer("Gencho");
        this.expected.add(one);
        this.expected.add(two);
        assertEquals(2, this.expected.getCount());
        this.expected.remove("Gencho");
        assertEquals(1, this.expected.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerShouldThrowIllegal() {
        HandballPlayer one = new HandballPlayer("Ivanov");
        HandballPlayer two = new HandballPlayer("Gencho");
        this.expected.add(one);
        this.expected.add(two);
        this.expected.remove("Pesho");
    }

    @Test
    public void testPlayerForAnotherTeamShouldFalse() {
        HandballPlayer one = new HandballPlayer("Ivanov");
        HandballPlayer two = new HandballPlayer("Gencho");
        this.expected.add(one);
        this.expected.add(two);
        this.expected.playerForAnotherTeam("Ivanov");
        assertFalse(one.isActive());
    }

    @Test
    public void testPlayerForAnotherTeamShouldTrue() {
        HandballPlayer one = new HandballPlayer("Ivanov");
        HandballPlayer two = new HandballPlayer("Gencho");
        this.expected.add(one);
        this.expected.add(two);
        assertTrue(one.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamShouldThrow() {
        HandballPlayer one = new HandballPlayer("Ivanov");
        HandballPlayer two = new HandballPlayer("Gencho");
        this.expected.add(one);
        this.expected.add(two);
        this.expected.playerForAnotherTeam("Pesho");
    }

    @Test
    public void testGetStatistics() {
        HandballPlayer one = new HandballPlayer("Ivanov");
        HandballPlayer two = new HandballPlayer("Gencho");
        this.expected.add(one);
        this.expected.add(two);
        String expected = "The player Ivanov, Gencho is in the team Vratsa.";
        String actual = this.expected.getStatistics();
        assertEquals(expected, actual);
    }
}
