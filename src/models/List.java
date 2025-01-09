package models;

import java.util.ArrayList;
import interfaces.IList;

public class List implements IList {

    private ArrayList<Task> tasks;
    private int id;
    private String name;

    public List(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int id) {
        return tasks.get(id - 1);
    }

    public void createTask(String name, String description)
    {
        int id = this.tasks.size();

        Task task = new Task(id, this.id, name, description);
        this.tasks.add(task);
    }

    public void deleteTask(int id)
    {
        this.tasks.remove(id - 1);
        this.updateTaskIds();
    }

    private void updateTaskIds()
    {
        for(Task task : tasks)
        {
            task.setId(this.tasks.indexOf(task) + 1);
        }
    }

    public String toString()
    {
        return this.id + "\n" + this.name + "\n";

    }

}
