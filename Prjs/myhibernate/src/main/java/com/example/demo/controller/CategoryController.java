package com.example.demo.controller;

import com.example.demo.models.Categories;
import com.example.demo.models.Products;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@Slf4j
public class CategoryController {
    @Autowired
    private ICategoryRepository repo;

    @PostMapping(value = "/create")
    public Categories create(@RequestBody Categories category) {
        return repo.save(category);
    }

    @GetMapping(value = "/get-all")
    public List<Categories> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/get-one")
    public Categories findById(@RequestParam Long id) {
        Optional<Categories> optionalCategory = repo.findById(id);
        if (!optionalCategory.isPresent()) {
            log.error("ID " + id + "is not exist");
            ResponseEntity.badRequest().build();
        }
        return optionalCategory.get();
    }
    @PutMapping(value = "/update")
    public Categories update(@RequestParam Long id,@RequestBody Categories category){
        if(!repo.findById(id).isPresent()){
            log.error("ID "+ id + "is not exist");
        }
        return repo.save(category);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long id){
        if(!repo.findById(id).isPresent()){
            log.error("ID "+ id + "is not exist");
            ResponseEntity.badRequest().build();
        }
        repo.deleteById(id);

    }
}
