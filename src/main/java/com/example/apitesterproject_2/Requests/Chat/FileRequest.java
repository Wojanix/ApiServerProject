package com.example.apitesterproject_2.Requests.Chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileRequest {
    private MultipartFile file;
    private Long user_id;
    private String user_name;
}
