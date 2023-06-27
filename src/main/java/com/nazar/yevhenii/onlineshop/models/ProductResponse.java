package com.nazar.yevhenii.onlineshop.models;

import com.nazar.yevhenii.onlineshop.models.enums.ResponseType;
import jakarta.persistence.*;

@Entity
public class ProductResponse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int rating;
    private int likes = 0;

    @Enumerated(EnumType.STRING)
    private ResponseType responseType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;

}