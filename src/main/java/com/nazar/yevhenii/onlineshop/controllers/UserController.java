package com.nazar.yevhenii.onlineshop.controllers;

import com.nazar.yevhenii.onlineshop.dtos.jwt.AuthenticationRequest;
import com.nazar.yevhenii.onlineshop.dtos.jwt.AuthenticationResponse;
import com.nazar.yevhenii.onlineshop.dtos.UserDTO;
import com.nazar.yevhenii.onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.register(userDTO));
    }
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(userService.authenticate(authenticationRequest));
    }

}
