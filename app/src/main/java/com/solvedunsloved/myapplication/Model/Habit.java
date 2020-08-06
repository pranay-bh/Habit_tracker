package com.solvedunsloved.myapplication.Model;

public class Habit {
    private String name;
    private String duration;
    private String description;
    private int id;

    public Habit() {
    }

    public Habit(String name, String duration, String description, int id) {
        this.name = name;
        this.duration = duration;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}