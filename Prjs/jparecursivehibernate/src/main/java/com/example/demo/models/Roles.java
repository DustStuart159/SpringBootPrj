package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "roles")
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String role_name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<Users> users = new HashSet<>();
}
