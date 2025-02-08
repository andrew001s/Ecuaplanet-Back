package com.grupo3.ecuaplanet.model;

public class Message {
    
    private String id;
    private String timestamp;
    private String sender;
    private String message;

    public Message() {
    }

    public Message(String timestamp, String sender, String message, String id) {
        this.timestamp = timestamp;
        this.sender = sender;
        this.message = message;
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
