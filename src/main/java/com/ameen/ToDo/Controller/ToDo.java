package com.ameen.ToDo.Controller;

public class ToDo {
    private int id;
    private String title;
    private String description;
    /* Constructor
     **/

    public ToDo(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    /* Getters & Setters
     **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
