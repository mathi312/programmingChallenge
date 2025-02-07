package com.infrafrontier.programmingChallenge.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String elementType, String id){
        super(String.format("%s with id %s already exists", elementType, id));
    }
}
