package com.stuart.hello_rest_db_swagger_hibernate.controllers;


import com.stuart.hello_rest_db_swagger_hibernate.modul.daos.ProductDAO;
import com.stuart.hello_rest_db_swagger_hibernate.modul.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private ProductDAO dao;

    @GetMapping("/")
    public List<ProductEntity> findAll(){
        return (List<ProductEntity>) dao.findAll();
    }
}
