package com.kacperdudz.multapp.controllers;

import com.kacperdudz.multapp.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("manage/api/users")
public class UserManagementController {

    private static final List<User> USERS = Arrays.asList(
            new User(1, "James Bond"),
            new User(2, "Nelson Amigos"),
            new User(3, "Jimmy Neutron")
    );

    @GetMapping
    public List<User> getAllUsers() {
        return USERS;
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        System.out.println(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user){
        System.out.println(String.format("%s %s", userId, user));
    }
}
