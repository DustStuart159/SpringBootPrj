package com.dust.myhibernate.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "my_hibernate")
@Data
@Table(name = "my_hibernate")
public class MyHibernateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
}
