package com.revature.techshop.controller;


import com.revature.techshop.entities.User;
import com.revature.techshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/users/{username}+{password}")
    public User login(@PathVariable("username")String username, @PathVariable("password") String password){
        return userService.login(username,password);
    }
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user){
        userService.updateUser(id,user);
        return "record updated";
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "record deleted successfully";
    }
}
