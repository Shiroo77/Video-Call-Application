package com.example.videocall;

import com.example.videocall.user.User;
import com.example.videocall.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideocallApplication.class, args);
    }

    // Command Line Runner is used to execute the code at application startup
    @Bean
    public CommandLineRunner commandLineRunner(UserService service) {
        return args -> {
            service.register(User.builder()
                    .username("kiara")
                    .email("kiara@gmail.com")
                    .password("aaa")
                    .build());

            service.register(User.builder()
                    .username("Alex")
                    .email("Alex@gmail.com")
                    .password("aaa")
                    .build());
        };
    }

}
