package com.example.lab3_b.model.matcher;

import com.example.lab3_b.model.Task;
import com.example.lab3_b.model.TaskState;

public class NotDoneMatcher implements ITaskMatcher{
    public boolean match(Task task){
        return task.getState() != TaskState.DONE;
    }
}
