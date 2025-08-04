package com.sujata.exception;

public class NoSuchBlogExistException extends RuntimeException{
    String message;
    public NoSuchBlogExistException(){

    }

    public NoSuchBlogExistException(String message){
        super(message);
        this.message=message;
    }
}
