package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getListId() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        assertEquals(1, task.getListId());
    }

    @Test
    void getId() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        assertEquals(1, task.getId());
    }

    @Test
    void getName() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        assertEquals("task1", task.getName());
    }

    @Test
    void getDescription() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        assertEquals("this is task 1", task.getDescription());
    }

    @Test
    void isDone() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        assertFalse(task.isDone());
    }

    @Test
    void setId() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        task.setId(2);
        assertEquals(2, task.getId());
    }

    @Test
    void setName() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        task.setName("task2");
        assertEquals("task2", task.getName());
    }

    @Test
    void setDescription() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        task.setDescription("this is task2");
        assertEquals("this is task2", task.getDescription());
    }

    @Test
    void setDone() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        task.setDone(true);
        assertTrue(task.isDone());
    }

    @Test
    void testToString() {
        Task task = new Task(1, 1, "task1", "this is task 1");
        assertEquals("1!task1!this is task 1!false!1!", task.toString());
    }
}