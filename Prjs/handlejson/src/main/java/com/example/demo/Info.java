package com.example.demo;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "info")
@Table(name = "info")
@Data
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String info;
}
