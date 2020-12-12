package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "products")
@Table(name = "products")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product_name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    /*@JsonManagedReference*/
    @JsonIgnore
    private Categories category;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    /*@JsonManagedReference*/
    @JsonIgnore
    private List<Orders> orders = new ArrayList<>();
}
