package com.example.apitesterproject_2.Controller;

import com.example.apitesterproject_2.Model.Chat.Chat;
import com.example.apitesterproject_2.Model.Chat.Message;
import com.example.apitesterproject_2.Model.Chat.MessageText;
import com.example.apitesterproject_2.Repository.Chat.ChatRepository;
import com.example.apitesterproject_2.Repository.Chat.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
//@RequestMapping("/chat")
@RequiredArgsConstructor
@Controller
public class ChatController extends TextWebSocketHandler {

    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")


    @PostMapping("/{address}")
    ResponseEntity<?> joinChat(@PathVariable String address){
        Chat chat = chatRepository.getChatByAddress(address);
        if(chat!=null){
            return ResponseEntity.ok(getMessages(address));
        } else if(chat==null){
            chat = Chat.builder()
                    .title(address)
                    .address(address)
                    .password("")
                    .create_date(LocalDateTime.now())
                    .is_private(false)
                    .build();
            chatRepository.save(chat);
        }
        return ResponseEntity.ok(true);
    }

    private List<Message> getMessages(String address){
        return messageRepository.findAllByChatAddress(address);
    }

    @PostMapping("/writeMessage")
    ResponseEntity<?> writeMessage(@RequestBody MessageText messageText){
        Long lastNumber= 0L;
        if(messageRepository.findLastByAddress(messageText.getChat_address())!=null){
            lastNumber = messageRepository.findLastByAddress(messageText.getChat_address()).getMessage_number()+1;
        }else {
            lastNumber = 0L;
        }
        Message message = Message.builder()
                .chat_address(messageText.getChat_address())
                .message_number(lastNumber)
                .text(messageText.getText())
                .user_id(messageText.getUser_id())
                .build();
        messageRepository.save(message);

        return ResponseEntity.ok(message);
    }


}
