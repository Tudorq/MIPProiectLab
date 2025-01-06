package models;

import java.util.ArrayList;
import interfaces.IList;

public class List implements IList {

    private ArrayList<Task> tasks;
    private int id;

    public List(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
