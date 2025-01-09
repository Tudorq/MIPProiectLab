package models;

import interfaces.ITask;

public class Task implements ITask {
    private int id;
    private int listId;
    private String name;
    private String description;
    private boolean done;

    public Task() {}

    public Task(int id, int listId, String name, String description) {
        this.id = id;
        this.listId = listId;
        this.name = name;
        this.description = description;
        this.done = false;
    }




    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setDone(boolean done) {
        this.done = done;
    }

    public String toString()
    {
        return this.id + "\n" + this.name + "\n" + this.description + "\n" + this.done + "\n" + this.listId + "\n";

    }
}
