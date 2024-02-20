package com.example.apitesterproject_2.Controller;

import com.example.apitesterproject_2.Model.Chat2.ChatMessage2;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/chat2")
@RequiredArgsConstructor
@Controller
public class WebSocketController {

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage2 register(@Payload ChatMessage2 chatMessage2, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", chatMessage2.getContent());

    return chatMessage2;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage2 sendMessage(@Payload ChatMessage2 chatMessage2){
        return chatMessage2;
    }
}
