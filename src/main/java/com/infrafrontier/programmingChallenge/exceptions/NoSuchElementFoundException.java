package com.infrafrontier.programmingChallenge.exceptions;

public class NoSuchElementFoundException extends RuntimeException {
    public NoSuchElementFoundException(String elementType, String id){
        super(String.format("%s with id %s not found", elementType, id));
    }
}
