package com.example.lab3_b.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Task implements Comparable<Task>, Serializable {
    private final String description;
    private final int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private Prio prio;

    Task(String description, Prio prio, int id) {
        this.description = description;
        this.id = id;
        this.prio = prio;
        this.takenBy = null;
        this.lastUpdate = LocalDate.now();
    }


    /**
     * @return what the task was taken by
     */
    public String getTakenBy() {
        return takenBy;
    }


    /** sets name of the one that has taken the task
     * @param takenBy the one who has taken the task
     * @throws IllegalStateException if the task is already taken
     */
    public void setTakenBy(String takenBy) throws IllegalStateException {
        if (this.takenBy == null){
            this.takenBy = takenBy;
            this.lastUpdate = LocalDate.now();
        }else{
            throw new IllegalStateException();
        }
    }


    /** Return the state of the task
     * @return the state of the task
     */
    public TaskState getState() {
        return state;
    }


    /** Sets the state of a task
     * @param state sets the state of a task
     */
    public void setState(TaskState state){
        this.state = state;
        this.lastUpdate = LocalDate.now();
    }


    /** Return the date of the last updated task
     * @return the date of the last updated task
     */
    public LocalDate getLastUpdate() {
        return lastUpdate;
    }


    /** Return the current prio
     * @return return the prio
     */
    public Prio getPrio() {
        return prio;
    }


    /** Set the specific prio
     * @param prio the spefic prio to be set
     */
    public void setPrio(Prio prio) {
        this.prio = prio;
        this.lastUpdate = LocalDate.now();
    }


    /** Return the priority comparing with a specific task. If the tasks have the same prio, then compare de prio of the description.
     * @param o the task to be compared.
     * @return return the priority order
     */
    @Override
    public int compareTo(Task o) {
        if (this.prio.compareTo(o.prio) == 0){
            return this.description.compareTo(o.description);
        }else{
            return this.prio.compareTo(o.prio);
        }
    }


    /** Checks if two tasks have the same description and priority
     * @param o the specific task to me compared with
     * @return true if the tasks have the same description and priority
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Task) {
            Task task = (Task) o;
            return Objects.equals(description, task.description) && prio == task.prio;
        }
        return false;
    }

    @Override
    public String toString() {
        return id + " " + takenBy + " " + description;
    }
}
