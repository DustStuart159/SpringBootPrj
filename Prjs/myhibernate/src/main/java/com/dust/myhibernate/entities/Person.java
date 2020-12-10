package com.dust.myhibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "person")
@Data
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Phone> phoneList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "person_country",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"))
    @JsonIgnore
    private List<Level> level = new ArrayList<>();
}
