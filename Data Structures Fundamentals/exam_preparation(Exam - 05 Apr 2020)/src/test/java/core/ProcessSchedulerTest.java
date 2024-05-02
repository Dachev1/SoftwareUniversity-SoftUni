package core;

import model.ScheduledTask;
import model.Task;
import org.junit.Before;
import org.junit.Test;
import shared.Scheduler;

import java.util.List;

import static org.junit.Assert.*;

public class ProcessSchedulerTest {
    private Scheduler scheduler;

    @Before
    public void setUp() {
        this.scheduler = new ProcessScheduler();
        for (int i = 1; i <= 20; i++) {
            this.scheduler.add(new ScheduledTask(i, "test_description"));
        }
    }

    @Test
    public void testPeekOnSingleElement() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(100, "test_description"));
        Task task = scheduler.peek();
        assertNotNull(task);
        assertEquals(100, task.getId());
    }

    @Test
    public void testPeekOnMultipleElement() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(73, "test_description"));
        for (int i = 1; i <= 20; i++) {
            scheduler.add(new ScheduledTask(i, "test_description"));
        }
        scheduler.add(new ScheduledTask(100, "test_description"));
        Task task = scheduler.peek();
        assertNotNull(task);
        assertEquals(73, task.getId());
    }

    @Test
    public void testAddOnMultipleElement() {
        Task task = this.scheduler.peek();
        assertNotNull(task);
        assertEquals(1, task.getId());
        assertEquals(20, this.scheduler.size());

        int expectedId = 1;
        while (this.scheduler.size() > 0) {
            Task process = this.scheduler.process();
            assertNotNull(process);
            assertEquals(expectedId++, process.getId());
        }
        assertEquals(21, expectedId);
    }

    @Test
    public void testAddOnSingleElement() {
        Scheduler scheduler = new ProcessScheduler();
        assertNull(scheduler.peek());
        assertEquals(0, scheduler.size());

        scheduler.add(new ScheduledTask(1, "test_description"));

        assertNotNull(scheduler.peek());
        assertEquals(1, scheduler.peek().getId());
        assertEquals(1, scheduler.size());
    }

    @Test
    public void testPeekShouldReturnCorrectAndShouldNotRemove() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(42, "test_description"));
        for (int i = 1; i <= 20; i++) {
            scheduler.add(new ScheduledTask(i, "test_description"));
        }
        Task task = scheduler.peek();
        assertNotNull(task);
        assertEquals(42, task.getId());
        assertEquals(21, scheduler.size());
        task = scheduler.peek();
        assertNotNull(task);
        assertEquals(42, task.getId());
        assertEquals(21, scheduler.size());
    }

    @Test
    public void testProcessShouldReturnCorrectAndShouldRemove() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(42, "test_description"));
        for (int i = 1; i <= 20; i++) {
            scheduler.add(new ScheduledTask(i, "test_description"));
        }
        Task task = scheduler.process();
        assertNotNull(task);
        assertEquals(42, task.getId());
        assertEquals(20, scheduler.size());
        task = scheduler.process();
        assertNotNull(task);
        assertEquals(1, task.getId());
        assertEquals(19, scheduler.size());
    }

    @Test
    public void testProcess() {
        this.scheduler.process();
        this.scheduler.process();

        assertEquals(3, this.scheduler.peek().getId());
    }

    @Test
    public void testContainsTrue() {
        assertTrue(this.scheduler.contains(new ScheduledTask(6, "test_description")));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(this.scheduler.contains(new ScheduledTask(22, "test_description")));
    }

    @Test
    public void testToList() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(1, "test_1"));
        scheduler.add(new ScheduledTask(2, "test_2"));
        scheduler.add(new ScheduledTask(3, "test_3"));
        scheduler.add(new ScheduledTask(4, "test_4"));
        scheduler.add(new ScheduledTask(5, "test_5"));

        List<Task> list = scheduler.toList();
        assertEquals("test_1", list.get(0).getDescription());
        assertEquals("test_3", list.get(2).getDescription());
        assertEquals("test_5", list.get(4).getDescription());
    }

    @Test
    public void testToArray() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(1, "test_1"));
        scheduler.add(new ScheduledTask(2, "test_2"));
        scheduler.add(new ScheduledTask(3, "test_3"));
        scheduler.add(new ScheduledTask(4, "test_4"));
        scheduler.add(new ScheduledTask(5, "test_5"));

        Task[] array = scheduler.toArray();
        assertEquals("test_1", array[0].getDescription());
        assertEquals("test_3", array[2].getDescription());
        assertEquals("test_5", array[4].getDescription());
    }

    @Test
    public void testReverse() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(1, "test_1"));
        scheduler.add(new ScheduledTask(2, "test_2"));
        scheduler.add(new ScheduledTask(3, "test_3"));
        scheduler.add(new ScheduledTask(4, "test_4"));
        scheduler.add(new ScheduledTask(5, "test_5"));

        scheduler.reverse();
        List<Task> list = scheduler.toList();
        assertEquals("test_5", list.get(0).getDescription());

    }
}