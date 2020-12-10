package com.dust.myhibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "level")
@Data
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String level;

    @ManyToMany(mappedBy = "level")
    @JsonIgnore
    private List<Person> person = new ArrayList<>();
}
