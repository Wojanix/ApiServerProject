package com.example.apitesterproject_2.Model.Chat2;

import lombok.Data;

@Data
public class ChatMessage2 {
    private String content;
    private String sender;
    private MessageType messageType;


    public enum MessageType{
        CHAT, LEAVE, JOIN
    }
}



