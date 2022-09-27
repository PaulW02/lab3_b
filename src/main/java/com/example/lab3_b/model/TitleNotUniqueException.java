package com.example.lab3_b.model;

public class TitleNotUniqueException extends RuntimeException{

    public TitleNotUniqueException(){
        super();
    }

    public TitleNotUniqueException(String msg){
        super(msg);
    }

}
