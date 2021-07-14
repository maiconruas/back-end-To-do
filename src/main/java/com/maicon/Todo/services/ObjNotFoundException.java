package com.maicon.Todo.services;

public class ObjNotFoundException extends  RuntimeException{

    public ObjNotFoundException(String message) {
        super(message);
    }

    public ObjNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
