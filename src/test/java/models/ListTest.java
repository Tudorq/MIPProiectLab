package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class ListTest {

    @Test
    void testGetId() {
        List list = new List(1, "List1");
        assertEquals(1, list.getId());
    }

    @Test
    void testSetId() {
        List list = new List(1, "List1");
        list.setId(2);
        assertEquals(2, list.getId());
    }

    @Test
    void testSetName() {
        List list = new List(1, "List1");
        list.setName("List2");
        assertEquals("List2", list.getName());
    }

    @Test
    void testGetName() {
        List list = new List(1, "List1");
        assertEquals("List1", list.getName());
    }

    @Test
    void testGetTasks() {
        List list = new List(1, "List1");
        list.createTask("task1", "this is task1");
        list.createTask("task2", "this is task2");
        Task testTask1 = new Task(1, 1, "task1", "this is task1");
        Task testTask2 = new Task(2, 1, "task2", "this is task2");
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(testTask1);
        tasks.add(testTask2);
        assertEquals(tasks.get(0).getId(), list.getTasks().get(0).getId());
        assertEquals(tasks.get(0).getListId(), list.getTasks().get(0).getListId());
        assertEquals(tasks.get(0).getName(), list.getTasks().get(0).getName());
        assertEquals(tasks.get(0).getDescription(), list.getTasks().get(0).getDescription());
        assertEquals(tasks.get(0).isDone(), list.getTasks().get(0).isDone());
        assertEquals(tasks.get(1).getId(), list.getTasks().get(1).getId());
        assertEquals(tasks.get(1).getListId(), list.getTasks().get(1).getListId());
        assertEquals(tasks.get(1).getName(), list.getTasks().get(1).getName());
        assertEquals(tasks.get(1).getDescription(), list.getTasks().get(1).getDescription());
        assertEquals(tasks.get(1).isDone(), list.getTasks().get(1).isDone());


    }

    @Test
    void testGetTask() {
        List list = new List(1, "List1");
        list.createTask("task1", "this is task1");
        Task testTask1 = new Task(1, 1, "task1", "this is task1");
        assertEquals(testTask1.getId(), list.getTask(1).getId());
        assertEquals(testTask1.getListId(), list.getTask(1).getListId());
        assertEquals(testTask1.getName(), list.getTask(1).getName());
        assertEquals(testTask1.getDescription(), list.getTask(1).getDescription());
        assertEquals(testTask1.isDone(), list.getTask(1).isDone());
    }

    @Test
    void testCreateTask() {
        List list = new List(1, "List1");
        list.createTask("task1", "this is task1");
        Task testTask1 = new Task(1, 1, "task1", "this is task1");
        assertEquals(testTask1.getId(), list.getTask(1).getId());
        assertEquals(testTask1.getListId(), list.getTask(1).getListId());
        assertEquals(testTask1.getName(), list.getTask(1).getName());
        assertEquals(testTask1.getDescription(), list.getTask(1).getDescription());
        assertEquals(testTask1.isDone(), list.getTask(1).isDone());
    }

    @Test
    void testDeleteTask() {
        List list = new List(1, "List1");
        list.createTask("task1", "this is task1");
        list.createTask("task2", "this is task2");
        list.deleteTask(2);
        assertEquals(list.getTasks().size(), 1);
    }

    @Test
    void testToString() {
        List list = new List(1, "List1");
        assertEquals("1!List1!", list.toString());
    }
}