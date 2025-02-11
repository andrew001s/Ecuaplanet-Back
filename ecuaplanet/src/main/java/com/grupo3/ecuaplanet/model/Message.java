package com.grupo3.ecuaplanet.model;

public class Message {
    
    private String user;
    private String timestamp;
    private String category;
    private String sender;
    private String message;

    public Message() {
    }

    public Message(String timestamp, String sender, String message, String user, String category) {
        this.timestamp = timestamp;
        this.sender = sender;
        this.message = message;
        this.user = user;
        this.category = category;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    
    
}
