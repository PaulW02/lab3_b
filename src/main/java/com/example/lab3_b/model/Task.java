package com.example.lab3_b.model;

import java.time.LocalDate;
import java.util.Objects;

public class Task implements Comparable<Task> {
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
    }

    public String getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(String takenBy) throws IllegalStateException {
        if (this.takenBy == null){
            this.takenBy = takenBy;
            this.lastUpdate = LocalDate.now();
        }else{
            throw new IllegalStateException();
        }
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state){
        this.state = state;
        this.lastUpdate = LocalDate.now();
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public Prio getPrio() {
        return prio;
    }

    public void setPrio(Prio prio) {
        this.prio = prio;
        this.lastUpdate = LocalDate.now();
    }

    @Override
    public int compareTo(Task o) {
        if (this.prio.compareTo(o.prio) == 0){
            return this.description.compareTo(o.description);
        }else{
            return this.prio.compareTo(o.prio);
        }
    }

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
        return "Task{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", takenBy='" + takenBy + '\'' +
                '}';
    }
}
