package com.example.apitesterproject_2.Model.Chat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {
    @Id
    private Long message_number;
    private String text;
    private String chat_address;
    private Long user_id;
}
