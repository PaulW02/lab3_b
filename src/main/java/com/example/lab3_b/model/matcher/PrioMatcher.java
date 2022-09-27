package com.example.lab3_b.model.matcher;

import com.example.lab3_b.model.Prio;
import com.example.lab3_b.model.Task;

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
