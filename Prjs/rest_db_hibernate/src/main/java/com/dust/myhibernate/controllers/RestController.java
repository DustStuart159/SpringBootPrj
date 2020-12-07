package com.dust.myhibernate.controllers;

import com.dust.myhibernate.dao.MyHibernateDAO;
import com.dust.myhibernate.entities.MyHibernateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private MyHibernateDAO dao;

    @GetMapping("/")
    public List<MyHibernateEntity> getAllRecords(){
        return dao.listAllRecords();
    }
}
