package com.example.apitesterproject_2.Controller;

import com.example.apitesterproject_2.Model.Chat.Chat;
import com.example.apitesterproject_2.Model.Chat.Message;
import com.example.apitesterproject_2.Model.Chat.Rank;
import com.example.apitesterproject_2.Model.Chat.User;
import com.example.apitesterproject_2.Repository.Chat.ChatRepository;
import com.example.apitesterproject_2.Repository.Chat.MessageRepository;
import com.example.apitesterproject_2.Repository.Chat.UserRepository;
import com.example.apitesterproject_2.Requests.Chat.FileRequest;
import com.example.apitesterproject_2.Requests.Chat.UserRequest;
import com.example.apitesterproject_2.Response.FileResponse;
import com.example.apitesterproject_2.uploadingfiles.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

//@CrossOrigin
//@RestController
////@RequestMapping("/chat2")
@RequiredArgsConstructor
@Controller
public class WebSocketController {

    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Autowired
    private final StorageService storageService;



    @MessageMapping("/chat.register/{channel}")
    @SendTo("/topic/public/{channel}")
    public Message register(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor, @DestinationVariable String channel) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getUser_name());
        chatMessage.setType("JOIN");
        return chatMessage;
    }

    @MessageMapping("/chat.send/{channel}")
    @SendTo("/topic/public/{channel}")
    public Message sendMessage(@Payload Message chatMessage, @DestinationVariable String channel) {
        if(chatMessage.getType()=="FILE"){
            Message message = Message.builder()
                    .user_name(chatMessage.getUser_name())
                    .user_id(chatMessage.getUser_id())
                    .type("FILE")
                    .text("Przesłano plik")
                    .file_path(chatMessage.getFile_path())
                    .message_number(messageRepository.count())
                    .chat_address(chatMessage.getChat_address())
                    .build();

            messageRepository.save(message);
            return message;
        }
            Message message = Message.builder()
                .user_name(chatMessage.getUser_name())
                .user_id(chatMessage.getUser_id())
                .type("SEND")
                .text(chatMessage.getText())
                .message_number(messageRepository.count())
                .chat_address(chatMessage.getChat_address())
                .build();
        messageRepository.save(message);
        return chatMessage;
    }

    @PostMapping("/sendFile/{channel}/{user_id}")
    public ResponseEntity<?> handleFileUpload(@RequestParam("formData") MultipartFile formData,
                                         RedirectAttributes redirectAttributes, @PathVariable String channel,  @PathVariable Long user_id) {

        storageService.store(formData);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + formData.getOriginalFilename() + "!");
        FileResponse response = new FileResponse("localhost:8080/getFile/" + formData.getOriginalFilename(), userRepository.getReferenceById(user_id).getName(), user_id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/getFile/{imageLink}", produces = MediaType.ALL_VALUE)
    public @ResponseBody byte[] getPng(@PathVariable String imageLink) throws IOException {
        String modifiedString = imageLink.replace('-', '/');
        byte[] response = getClass().getResourceAsStream("file:upload-dir/"+modifiedString).readAllBytes();
        return response;
    }



    @PostMapping("/createUser")
    ResponseEntity<?> createUser(@RequestBody UserRequest userArg)
    {

        User user = User.builder()
                .user_id(userRepository.count()+1)
                .name(userArg.getName())
                .rank(Rank.USER)
                .build();

        userRepository.save(user);

        return ResponseEntity.ok(user.getUser_id());
    }

    @PostMapping("/getChat/{address}")
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


}
