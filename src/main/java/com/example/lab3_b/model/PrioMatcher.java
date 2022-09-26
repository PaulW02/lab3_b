package com.example.lab3_b.model;

import javafx.concurrent.Task;

public class PrioMatcher implements ITaskMatcher{
    private Prio prio;

    public PrioMatcher(Prio prio) {
        this.prio = prio;
    }

    @Override
    public boolean match(Task task) {
        return true;
    }
}
