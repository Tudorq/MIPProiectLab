package interfaces;

import models.Task;

import java.util.ArrayList;

public interface IList {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public ArrayList<Task> getTasks();

    public Task getTask(int id);

    public void createTask(String name, String description);

    public void addTask(String name, String description, boolean status);

    public void deleteTask(int id);

    public String toString();
}
