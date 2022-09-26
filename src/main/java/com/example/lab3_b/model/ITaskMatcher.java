package com.example.lab3_b.model;

import javafx.concurrent.Task;

public interface ITaskMatcher {
    abstract public boolean match(Task task);
}
