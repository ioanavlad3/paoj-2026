package com.pao.laboratory03.bonus;

public class TaskNotFoundException extends RuntimeException{
    TaskNotFoundException(String msg) {
        super(msg);
    }
}
