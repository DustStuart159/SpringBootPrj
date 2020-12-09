package com.stuart.hello_rest_db_swagger_hibernate.controllers;

import com.stuart.hello_rest_db_swagger_hibernate.ProductDAO;
import com.stuart.hello_rest_db_swagger_hibernate.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private ProductDAO dao;

    @GetMapping("/")
    public List<ProductEntity> getAllRecords(){
        return dao.listAllRecords();
    }
}
