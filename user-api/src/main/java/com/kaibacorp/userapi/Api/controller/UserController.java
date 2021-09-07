package com.kaibacorp.userapi.Api.controller;

import com.kaibacorp.userapi.Domain.model.User;
import com.kaibacorp.userapi.Domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name="User Endpoint")
@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Add new User")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @Operation(summary = "List all users")
    @GetMapping
    public List<User> listAll(){
        return userService.allUsers();
    }

    @Operation(summary = "Find user by id")
    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id){
        return userService.searchUser(id);
    }

    @Operation(summary = "Update user")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable Long id, User user){
        return userService.updateUser(id,user);
    }

    @Operation(summary = "Delete user")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        userService.removeUser(id);
    }

    public String fallbackMethod(Exception ex){
        return "Error in your Requisition, try again";
    }
}
