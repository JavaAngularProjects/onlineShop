package com.nazar.yevhenii.onlineshop.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDTO {
    private String email;
    private String password;
    private String firstname;
    private String surname;
    private String phoneNumber;

}

