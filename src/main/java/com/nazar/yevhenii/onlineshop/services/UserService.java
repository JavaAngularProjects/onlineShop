package com.nazar.yevhenii.onlineshop.services;

import com.nazar.yevhenii.onlineshop.daos.UserDAO;
import com.nazar.yevhenii.onlineshop.dtos.AuthenticationResponse;
import com.nazar.yevhenii.onlineshop.dtos.UserDTO;
import com.nazar.yevhenii.onlineshop.models.enums.Role;
import com.nazar.yevhenii.onlineshop.models.user.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDAO userDAO;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    //Registration
    public AuthenticationResponse register(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setUserRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDate.now().toString());

        if (userDAO.existsByEmail(user.getEmail()))
            throw new IllegalArgumentException("This email is taken");
        userDAO.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    //Authentication
    public AuthenticationResponse authenticate(UserDTO userDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword()));
        User user = userDAO.findUserByEmail(userDTO.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public void addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userDAO.save(user);

    }

}
