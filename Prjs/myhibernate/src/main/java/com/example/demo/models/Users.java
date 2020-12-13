package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@ToString
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String user_name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Orders> orders = new HashSet<>();

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Roles> roles = new HashSet<>();
}
