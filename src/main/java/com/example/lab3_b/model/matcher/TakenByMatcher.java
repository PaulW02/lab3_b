package com.example.lab3_b.model.matcher;

import com.example.lab3_b.model.Task;

import java.util.Objects;

public class TakenByMatcher implements ITaskMatcher {
    private final String takenBy;

    public TakenByMatcher(String takenBy) {
        this.takenBy = takenBy;
    }

    @Override
    public boolean match(Task task) {
        return Objects.equals(task.getTakenBy(), this.takenBy);
    }
}
