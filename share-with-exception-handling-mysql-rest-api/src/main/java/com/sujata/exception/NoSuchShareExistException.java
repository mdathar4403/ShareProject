package com.sujata.exception;

public class NoSuchShareExistException extends RuntimeException{
    String message;
    public NoSuchShareExistException(){

    }

    public NoSuchShareExistException(String message){
        super(message);
        this.message=message;
    }
}
