package com.example.lab3_b.model;
import javafx.concurrent.Task;

public class NotDoneMatcher implements ITaskMatcher{
    public boolean match(Task task){
        return false;
    }
}
