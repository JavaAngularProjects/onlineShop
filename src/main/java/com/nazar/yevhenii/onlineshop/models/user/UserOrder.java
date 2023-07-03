package com.nazar.yevhenii.onlineshop.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nazar.yevhenii.onlineshop.models.product.Product;
import com.nazar.yevhenii.onlineshop.models.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserOrder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalPrice;
    private String createdAt;


    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserAddress userAddress;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserPaymentMethod userPaymentMethod;

    @ElementCollection
    @JsonIgnore
    private HashMap<Product, Integer> products = new HashMap<>();
}
