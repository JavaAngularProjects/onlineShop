package com.nazar.yevhenii.onlineshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class HomeAddress {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
}
