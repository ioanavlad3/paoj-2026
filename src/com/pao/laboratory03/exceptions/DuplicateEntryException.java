package com.pao.laboratory03.exceptions;

public class DuplicateEntryException extends RuntimeException{
    DuplicateEntryException(String msg) {
        super(msg);
    }
}
