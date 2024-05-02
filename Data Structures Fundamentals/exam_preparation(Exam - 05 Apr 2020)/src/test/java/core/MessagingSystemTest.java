package core;

import model.Message;
import model.TextMessage;
import org.junit.Before;
import org.junit.Test;
import shared.DataTransferSystem;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MessagingSystemTest {
    private List<Message> messages;

    private DataTransferSystem system;

    @Before
    public void setUp() {
        this.messages = List.of(
                new TextMessage(11, "test_11"),
                new TextMessage(6, "test_6"),
                new TextMessage(19, "test_19"),
                new TextMessage(4, "test_4"),
                new TextMessage(8, "test_8"),
                new TextMessage(17, "test_17")
        );

        this.system = new MessagingSystem();

        assertEquals(0, this.system.size());

        for (Message message : this.messages) {
            this.system.add(message);
        }
    }

    @Test
    public void testAddSingleShouldWorkCorrectly() {
        DataTransferSystem system = new MessagingSystem();

        assertEquals(0, system.size());

        system.add(new TextMessage(12, "test_text"));

        assertEquals(1, system.size());
    }

    @Test
    public void testAddMultipleShouldWorkCorrectly() {
        DataTransferSystem system = new MessagingSystem();

        assertEquals(0, system.size());

        for (Message message : messages) {
            system.add(message);
        }

        assertEquals(messages.size(), system.size());
    }

    @Test
    public void testAddMultipleShouldSetCorrectElements() {
        assertEquals(messages.size(), system.size());
        Message lightest = system.getLightest();
        assertNotNull(lightest);
        assertEquals(4, lightest.getWeight());
        Message heaviest = system.getHeaviest();
        assertNotNull(heaviest);
        assertEquals(19, heaviest.getWeight());
    }

    @Test
    public void testGetPostOrderShouldReturnCorrectSequence() {
        List<Message> postOrder = this.system.getPostOrder();

        int[] expected = {4, 8, 6, 17, 19, 11};
        assertNotNull(postOrder);
        assertEquals(expected.length, postOrder.size());

        for (int i = 0; i < messages.size(); i++) {
            assertEquals(expected[i], postOrder.get(i).getWeight());
        }
    }

    @Test
    public void testGetLightestShouldReturnCorrect() {
        Message lightest = this.system.getLightest();
        assertNotNull(lightest);
        assertEquals(4, lightest.getWeight());
    }

    @Test
    public void testGetHeaviestShouldReturnCorrect() {
        Message heaviest = this.system.getHeaviest();
        assertNotNull(heaviest);
        assertEquals(19, heaviest.getWeight());
    }

    @Test
    public void testGetByWeight() {
        assertEquals("test_11", this.system.getByWeight(11).getText());
    }

    @Test
    public void testGetLightest() {
        assertEquals(4, this.system.getLightest().getWeight());
    }

    @Test
    public void testGetHeaviest() {
        assertEquals(19, this.system.getHeaviest().getWeight());
    }

    @Test
    public void testDeleteLightest() {
        assertEquals(4, this.system.getLightest().getWeight());
        assertEquals(6, this.system.size());

        this.system.deleteLightest();

        assertEquals(6, this.system.getLightest().getWeight());
        assertEquals(5, this.system.size());
    }

    @Test
    public void testDeleteHeaviest() {
        assertEquals(19, this.system.getHeaviest().getWeight());
        assertEquals(6, this.system.size());

        this.system.deleteHeaviest();

        assertEquals(17, this.system.getHeaviest().getWeight());
        assertEquals(5, this.system.size());
    }

    @Test
    public void testPostOrder() {
        List<Message> expected = List.of(
                new TextMessage(4, "test_4"),
                new TextMessage(8, "test_8"),
                new TextMessage(6, "test_6"),
                new TextMessage(17, "test_17"),
                new TextMessage(19, "test_19"),
                new TextMessage(11, "test_11")
        );

        assertEquals(expected, this.system.getPostOrder());
    }

    @Test
    public void testPreOrder() {
        List<Message> expected = List.of(
                new TextMessage(11, "test_11"),
                new TextMessage(6, "test_6"),
                new TextMessage(4, "test_4"),
                new TextMessage(8, "test_8"),
                new TextMessage(19, "test_19"),
                new TextMessage(17, "test_17")

        );

        assertEquals(expected, this.system.getPreOrder());
    }

    @Test
    public void testInOrder() {
        List<Message> expected = List.of(
                new TextMessage(4, "test_4"),
                new TextMessage(6, "test_6"),
                new TextMessage(8, "test_8"),
                new TextMessage(11, "test_11"),
                new TextMessage(17, "test_17"),
                new TextMessage(19, "test_19")
        );

        assertEquals(expected, this.system.getInOrder());
    }

    @Test
    public void testContainsShouldReturnTrue() {
        assertTrue(this.system.contains( new TextMessage(4, "test_4")));
    }

    @Test
    public void testContainsShouldReturnFalse() {
        assertFalse(this.system.contains( new TextMessage(99, "test_99")));
    }
}