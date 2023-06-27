package com.nazar.yevhenii.onlineshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nazar.yevhenii.onlineshop.models.enums.OrderStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class UserOrder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private HomeAddress homeAddress;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();


}
