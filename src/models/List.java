package models;

import java.util.ArrayList;
import interfaces.IList;

public class List implements IList {

    private ArrayList<Task> tasks;
    private int id;
    private String name;

    public List(int id) {
        this.id = id;
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

    }

    public void deleteTask(int id)
    {

    }

}
