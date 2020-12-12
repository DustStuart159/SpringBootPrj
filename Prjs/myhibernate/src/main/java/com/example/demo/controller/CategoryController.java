package com.example.demo.controller;

import com.example.demo.models.Categories;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.dto.CategoryDTO;
import com.example.demo.service.impl.CategoryServiceImpl;
import com.example.demo.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl categoryServiceImpl;
    @Autowired
    private ICategoryRepository repo;

    @Transactional
    @PostMapping(value = "/create")
    public CategoryDTO create(@RequestBody CategoryDTO category) {
        return categoryServiceImpl.save(category);
    }

    @GetMapping(value = "/get-all")
    public List<CategoryDTO> findAll() {
        return categoryServiceImpl.findAll();
    }

    @GetMapping(value = "/get-one")
    public CategoryDTO findById(@RequestParam Long id) {
        return categoryServiceImpl.findById(id);
    }

    /*@GetMapping(value = "/get-all")
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

    }*/
}
