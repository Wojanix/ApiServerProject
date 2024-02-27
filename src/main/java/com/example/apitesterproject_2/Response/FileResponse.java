package com.example.apitesterproject_2.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileResponse {
    private String link;
    private String user_name;
    private Long user_id;
}
