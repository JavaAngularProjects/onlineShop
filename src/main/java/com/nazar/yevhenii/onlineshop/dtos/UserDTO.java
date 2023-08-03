package com.nazar.yevhenii.onlineshop.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String email;
    private String firstname;
    private String surname;
    private String phoneNumber;

}

