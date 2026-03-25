package com.pao.laboratory04.bonus;

public class TaskNotFoundException extends RuntimeException{
    TaskNotFoundException(String msg) {
        super(msg);
    }
}
