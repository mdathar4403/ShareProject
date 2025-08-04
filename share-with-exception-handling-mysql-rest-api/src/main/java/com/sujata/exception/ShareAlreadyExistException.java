package com.sujata.exception;

public class ShareAlreadyExistException extends RuntimeException{
    String message;
    public ShareAlreadyExistException(){

    }

    public ShareAlreadyExistException(String message){
        super(message);
        this.message=message;
    }
}
