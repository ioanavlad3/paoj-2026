package com.pao.laboratory04.exceptions;

public class DuplicateEntryException extends RuntimeException{
    DuplicateEntryException(String msg) {
        super(msg);
    }
}
