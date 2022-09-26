package com.example.lab3_b.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task implements Comparable {
    private String description;
    private int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private Prio prio;



    Task(String description, Prio prio, int id) {
        this.description = description;
        this.id = id;
        this.prio = prio;
    }

    public void setTakenBy(String takenBy) {
        this.takenBy = takenBy;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public void setPrio(Prio prio) {
        this.prio = prio;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
