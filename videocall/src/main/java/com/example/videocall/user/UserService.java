package com.example.videocall.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {

    private static final List<User> USER_LIST = new ArrayList<>();

    // Method to register user
    public void register(User user){
        // When we register the user the status by default should be online
        user.setStatus("online");
        USER_LIST.add(user);
    }

    // Method to login
    public User login(User user){
        // the code finds the index of a user with a specific email in the USER_LIST:
        var userIndex = IntStream.range(0, USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny() // It's used here to get any index that matches the filter condition.
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Once we get the index, Use that to find the user inside the list
        var cUser = USER_LIST.get(userIndex);
        if(!cUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Password Incorrect");
        }
        cUser.setStatus("online");
        return cUser;
    }

    // Method to logout
    public void logout(String email){
        var userIndex = IntStream.range(0, USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(email))
                .findAny() // It's used here to get any index that matches the filter condition.
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Once the user is logged out. Set the status to offline
        USER_LIST.get(userIndex).setStatus("offline");
    }

    // List of users
    public List<User> findAll(){
        return USER_LIST;
    }










}



















































