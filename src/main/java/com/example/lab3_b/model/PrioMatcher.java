package com.example.lab3_b.model;

public class PrioMatcher implements ITaskMatcher{
    private final Prio prio;

    public PrioMatcher(Prio prio) {
        this.prio = prio;
    }

    @Override
    public boolean match(Task task) {
        return this.prio == task.getPrio();
    }
}
