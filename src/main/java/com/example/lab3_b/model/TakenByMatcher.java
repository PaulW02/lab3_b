package com.example.lab3_b.model;

import java.util.Objects;

public class TakenByMatcher implements ITaskMatcher {
    private final Email takenBy;

    public TakenByMatcher(Email takenBy) {
        this.takenBy = takenBy;
    }

    @Override
    public boolean match(Task task) {
        return Objects.equals(task.getTakenBy(), this.takenBy.getAsString());
    }
}
