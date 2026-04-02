package com.srijan.chat;

public class Message {
    private String senderId;
    private String senderEmail;
    private String receiverId;
    private String message;
    private long timestamp;

    public Message() {}

    public Message(String senderId, String senderEmail, String receiverId, String message, long timestamp) {
        this.senderId = senderId;
        this.senderEmail = senderEmail;
        this.receiverId = receiverId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getSenderId() { return senderId; }
    public String getSenderEmail() { return senderEmail; }
    public String getReceiverId() { return receiverId; }
    public String getMessage() { return message; }
    public long getTimestamp() { return timestamp; }
}