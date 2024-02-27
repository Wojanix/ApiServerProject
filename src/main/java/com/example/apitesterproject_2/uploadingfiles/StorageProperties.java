package com.example.apitesterproject_2.uploadingfiles;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component("storage")
public class StorageProperties {
    private String location = "upload-dir";

}