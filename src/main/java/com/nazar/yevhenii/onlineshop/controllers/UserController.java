package com.nazar.yevhenii.onlineshop.controllers;

import com.nazar.yevhenii.onlineshop.dtos.AuthenticationResponse;
import com.nazar.yevhenii.onlineshop.dtos.UserDTO;
import com.nazar.yevhenii.onlineshop.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String sayHello(){
        return "hello";
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.register(userDTO));
    }
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.authenticate(userDTO));
    }

}
