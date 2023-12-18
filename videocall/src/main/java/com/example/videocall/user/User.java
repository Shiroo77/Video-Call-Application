package com.example.videocall.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String username;
    private String email;
    private String password;
    // This will hold the status of the user
    // Whether they're online or offline
    private String status;
}
