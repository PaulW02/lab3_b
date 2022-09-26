package com.example.lab3_b.model;

import javafx.concurrent.Task;

import java.util.ArrayList;

public class TakenByMatcher implements ITaskMatcher {
    private String takenBy;

    public TakenByMatcher(String takenBy) {
        this.takenBy = takenBy;
    }

    @Override
    public boolean match(Task task) {
        return false;
    }
}
