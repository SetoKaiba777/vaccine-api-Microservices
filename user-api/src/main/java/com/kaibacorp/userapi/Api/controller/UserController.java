package com.kaibacorp.userapi.Api.controller;

import com.kaibacorp.userapi.Domain.model.User;
import com.kaibacorp.userapi.Domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> listAll(){
        return userService.allUsers();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id){
        return userService.searchUser(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable Long id, User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        userService.removeUser(id);
    }

    public String fallbackMethod(Exception ex){
        return "Error in your Requisition, try again";
    }
}
