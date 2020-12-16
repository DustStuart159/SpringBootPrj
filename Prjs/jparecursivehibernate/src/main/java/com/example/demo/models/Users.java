package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contacts contact;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Roles role;
}
