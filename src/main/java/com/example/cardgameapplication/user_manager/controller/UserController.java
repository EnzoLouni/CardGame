package com.example.cardgameapplication.user_manager.controller;

import com.example.cardgameapplication.user_manager.dto.AuthDto;
import com.example.cardgameapplication.user_manager.dto.UserDto;
import com.example.cardgameapplication.user_manager.service.UserService;
import com.example.cardgameapplication.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @JsonView(Views.UserView.class)
    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable("id") Integer id, @RequestBody @Valid UserDto newUserDto) {
        userService.updateUser(id, newUserDto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }

    @PostMapping("/user")
    public boolean createUser(@RequestBody @Valid UserDto user)
    {
        return userService.createUser(user);
    }

    @PostMapping("/auth")
    public boolean authentication(@RequestBody @Valid AuthDto request)
    {
        return userService.authenticate(request);
    }

    @JsonView(Views.UserView.class)
    @GetMapping("/users")
    public List<UserDto> getUsers()
    {
        return userService.getUsers();
    }
}

