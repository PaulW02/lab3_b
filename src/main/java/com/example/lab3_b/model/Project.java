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

    /** Finds a task through its ID and returns the task
     * @param id the id of a specific task
     * @return the task of the specified ID
     */
    public Task getTaskById(int id){
        return tasks.get(id);
    }

    /**
     * @param matcher matches tasks based on what type of matcher it is
     * @return returns the found tasks
     */
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


    /**
     * Adds a new task to the tasks list
     * @param description the description of the new task
     * @param prio the prioritization of the new task
     */
    public void addTask(String description, Prio prio){
        tasks.add(new Task(description, prio, nextTaskId));
        nextTaskId++;
    }


    /**
     * Removes a specific task from the project
     * @param task the task that will be removed
     * @return the task that was removed
     */
    public Task removeTask(Task task){
        tasks.remove(task);
        return task;
    }


    /**
     * Return the title
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /** Calculates the state of the project through the tasks in it.
     * @return the state of the project, whether it is empty, ongoing or completed.
     */
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


    /** Go through all tasks and return the date of the last updated task.
     * @return the date of the last updated task.
     */
    public LocalDate getLastUpdated(){
        LocalDate lastUpdated = tasks.get(0).getLastUpdate();

        for (Task t: tasks) {
            if (t.getLastUpdate().isAfter(lastUpdated)){
                lastUpdated = t.getLastUpdate();
            }
        }
        return lastUpdated;
    }

    /** Compare the title of a specific project with another title and return it
     * @param o the object to be compared.
     * @return the comparison of titles from two projects
     */
    @Override
    public int compareTo(Project o) {
        return this.getTitle().compareTo(o.getTitle());
    }


    /**
     * Returns whether the specified project has the same description as the other object or not.
     * @param o the project to be compared to
     * @return true if the description of the projects are the same and false if not.
     */
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
