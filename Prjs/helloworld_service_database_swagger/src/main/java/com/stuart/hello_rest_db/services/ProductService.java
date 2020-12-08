package com.stuart.hello_rest_db.services;

import com.stuart.hello_rest_db.modul.Entities.ProductEntity;
import com.stuart.hello_rest_db.modul.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<ProductEntity> listAll(){
        return repo.findAll();
    }

    public void save(ProductEntity product){
        repo.save(product);
    }

    public ProductEntity get(long id){
        return repo.findById(id).get();
    }

    public void delete(long id){
        repo.deleteById(id);
    }

    public ProductEntity getByName(String name){return null;}

}
