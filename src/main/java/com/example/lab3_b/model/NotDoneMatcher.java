package com.example.lab3_b.model;

public class NotDoneMatcher implements ITaskMatcher{
    public boolean match(Task task){
        return task.getState() != TaskState.DONE;
    }
}
