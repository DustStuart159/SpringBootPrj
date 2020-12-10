package com.dust.myhibernate.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "address")
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;

    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}
