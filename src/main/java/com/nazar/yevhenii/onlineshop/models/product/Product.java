package com.nazar.yevhenii.onlineshop.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nazar.yevhenii.onlineshop.models.category.Characteristic;
import com.nazar.yevhenii.onlineshop.models.category.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private short rating;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIgnore
    private List<ProductResponse> productResponses = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "products")
    @JsonIgnore
    private List<Characteristic> characteristics = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Type type;
}
