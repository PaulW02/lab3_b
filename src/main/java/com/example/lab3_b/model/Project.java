package com.example.lab3_b.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project implements Comparable{
    private String title;
    private int id;
    private String description;
    private LocalDate created;
    private int nextTaskId;
    private List<Task> tasks;

    public Project(String title, int id, String description) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.tasks = new ArrayList<>();
    }

    public Task getTaskById(int id){
        return tasks.get(id);
    }

    public List<Task> findTasks(ITaskMatcher matcher){

    }

    public void addTask(String description, Prio prio){
        tasks.add(new Task(description, prio, nextTaskId));
    }

    public Task removeTask(Task task){
        tasks.remove(task);
        return task;
    }

    public String getTitle() {
        return title;
    }

    public ProjectState getState(){
        return ProjectState.EMPTY;
    }

    public LocalDate getLastUpdated(){
        return created;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
