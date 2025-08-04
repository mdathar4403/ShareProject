package com.sujata.exception;

public class BlogAlreadyExistException extends RuntimeException{
    String message;
    public BlogAlreadyExistException(){

    }

    public BlogAlreadyExistException(String message){
        super(message);
        this.message=message;
    }
}
