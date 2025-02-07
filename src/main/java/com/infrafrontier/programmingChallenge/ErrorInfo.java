package com.infrafrontier.programmingChallenge;

import java.time.LocalDateTime;
import java.util.Map;


public class ErrorInfo {
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;
    private final String path;

    private Map<String, String> errors;

    public ErrorInfo(int status, String message, LocalDateTime timestamp, String path){
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
    }

    public ErrorInfo(int status, String message, LocalDateTime timestamp, String path, Map<String, String> errors){
        this(status, message, timestamp, path);
        this.errors = errors;
    }

    public int getStatusCode(){
        return status;
    }

    public String getMessage(){
        return message;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public String getPath(){
        return path;
    }

    public Map<String, String> getErrors(){
        return errors;
    }
}
