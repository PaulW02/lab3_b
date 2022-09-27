package com.example.lab3_b.model.matcher;

import com.example.lab3_b.model.Task;

public class AllTasksMatcher implements ITaskMatcher {
    @Override
    public boolean match(Task task) {
        return true;
    }
}
