package com.example.apitesterproject_2.Model.Chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageText {
    private Long user_id;
    private String text;
    private String chat_address;
}
