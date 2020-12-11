package com.example.demo.controller;

import com.example.demo.models.Products;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.impl.CategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    @Autowired
    private IProductRepository productRepo;
    @Autowired
    private ICategoryRepository categoryRepo;

    @PostMapping(value = "/create")
    public Products create(@RequestBody Products products) {
        return productRepo.save(products);
    }

    @GetMapping(value = "/get-all")
    public List<Products> findAll() {
        return productRepo.findAll();
    }

    @GetMapping(value = "/get-one")
    public Products findById(@RequestParam Long id) {
        Optional<Products> optionalProducts = productRepo.findById(id);
        if (!optionalProducts.isPresent()) {
            log.error("ID " + id + "is not exist");
            ResponseEntity.badRequest().build();
        }
        return optionalProducts.get();
    }
    @PutMapping(value = "/update")
    public Products update(@RequestParam Long id,@RequestBody Products products){
        if(!productRepo.findById(id).isPresent()){
            log.error("ID "+ id + "is not exist");
        }
        return productRepo.save(products);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long id){
        if(!productRepo.findById(id).isPresent()){
            log.error("ID "+ id + "is not exist");
            ResponseEntity.badRequest().build();
        }
        productRepo.deleteById(id);

    }
}
