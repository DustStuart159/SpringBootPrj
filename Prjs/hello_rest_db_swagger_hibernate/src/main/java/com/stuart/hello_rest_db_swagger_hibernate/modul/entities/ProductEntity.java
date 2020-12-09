package com.stuart.hello_rest_db_swagger_hibernate.modul.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "product")
@Data
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private float price;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
