package com.example.lab3_b.model;

import com.example.lab3_b.model.matcher.ITaskMatcher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project implements Comparable<Project>, Serializable { //sätta till implements Serializable
    private final String title;
    private final int id;
    private final String description;
    private final LocalDate created;
    private final List<Task> tasks;
    private int nextTaskId;

    Project(String title, int id, String description) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.tasks = new ArrayList<>();
        this.created = LocalDate.now();
        this.nextTaskId = 0;
    }

    public Task getTaskById(int id){
        return tasks.get(id);
    }

    public List<Task> findTasks(ITaskMatcher matcher){
        List<Task> foundTasks = new ArrayList<>();
        Task temp;
        for (Task t: tasks) {
            if (matcher.match(t)){
                foundTasks.add(t);
            }
        }

        for (int i = 0; i < foundTasks.size()-1; i++) {
            if (foundTasks.get(i).compareTo(foundTasks.get(i+1)) > 0){
                temp = foundTasks.get(i);
                foundTasks.set(i, foundTasks.get(i+1));
                foundTasks.set(i+1, temp);
            }
        }

        return foundTasks;
    }

    public void addTask(String description, Prio prio){
        tasks.add(new Task(description, prio, nextTaskId));
        nextTaskId++;
    }

    public Task removeTask(Task task){
        tasks.remove(task);
        return task;
    }

    public String getTitle() {
        return title;
    }

    public ProjectState getState(){
        int counter = 0;

        if (tasks.size() == 0){
            return ProjectState.EMPTY;
        }

        for (Task t: tasks) {
            if (t.getState() == TaskState.DONE){
                counter++;
            }
        }
        if (counter == tasks.size()){
            return ProjectState.COMPLETED;
        }else{
            return ProjectState.ONGOING;
        }
    }

    public LocalDate getLastUpdated(){
        LocalDate lastUpdated = tasks.get(0).getLastUpdate();

        for (Task t: tasks) {
            if (t.getLastUpdate().isAfter(lastUpdated)){
                lastUpdated = t.getLastUpdate();
            }
        }
        return lastUpdated;
    }

    @Override
    public int compareTo(Project o) {
        return this.getTitle().compareTo(o.getTitle());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Project) {
            Project project = (Project) o;
            return Objects.equals(description, project.description);
        }
        return false;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + description;
    }
}
