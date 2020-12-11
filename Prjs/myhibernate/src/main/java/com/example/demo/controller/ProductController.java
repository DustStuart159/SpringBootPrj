package com.example.demo.controller;

import com.example.demo.models.Products;
import com.example.demo.service.dto.ProductDTO;
import com.example.demo.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @PostMapping(value = "/create")
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        return productServiceImpl.save(productDTO);
    }

    /*@GetMapping(value = "/get-all")
    public List<ProductDTO> findAll() {
        return productServiceImpl.finAll();
    }

    @GetMapping(value = "/get-one")
    public Products findById(@RequestParam Long id) {
        Optional<Products> optionalProducts = productServiceImpl.findById(id);
        if (!optionalProducts.isPresent()) {
            log.error("ID " + id + "is not exist");
            ResponseEntity.badRequest().build();
        }
        return optionalProducts.get();
    }
    @PutMapping(value = "/update")
    public Products update(@RequestParam Long id,@RequestBody Products products){
        if(!productServiceImpl.findById(id).isPresent()){
            log.error("ID "+ id + "is not exist");
        }
        return productServiceImpl.save(products);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long id){
        if(!productServiceImpl.findById(id).isPresent()){
            log.error("ID "+ id + "is not exist");
            ResponseEntity.badRequest().build();
        }
        productServiceImpl.deleteById(id);

    }*/
}
