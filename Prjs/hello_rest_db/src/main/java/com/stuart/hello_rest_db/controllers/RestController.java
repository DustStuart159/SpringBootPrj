package com.stuart.hello_rest_db.controllers;

import com.stuart.hello_rest_db.error.BookNotFoundException;
import com.stuart.hello_rest_db.error.BookUnSupportedFieldPatchException;
import com.stuart.hello_rest_db.modul.Product;
import com.stuart.hello_rest_db.modul.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private ProductRepository repository;

    // Tìm tất cả sách trong repository
    @GetMapping("/api/products")
    List<Product> findAll(){
        return repository.findAll();
    }

    // Thêm sách vào repository
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/products")
    Product newBook(@RequestBody Product newBook){
        return repository.save(newBook);
    }

    // Tìm product theo id
    @GetMapping("/api/products/{id}")
    Product findOne(@PathVariable Long id){
        try {
            return repository.findOne(id);
        }catch (Exception e) {
            throw  new BookNotFoundException(id);
        }
    }

    // sửa thông tin sách theo id
    @PutMapping("/api/products/{id}")
    Product saveOrUpdate(@RequestBody Product newBook, @PathVariable Long id){
        try {
            Product product = repository.findOne(id);
            product.setName(newBook.getName());
            product.setAuthor(newBook.getAuthor());
            product.setPrice(newBook.getPrice());

            return product;
        } catch (Exception e){
            newBook.setId(id);
            return  repository.save(newBook);
        }
    }

    //sửa thông tin author của sách theo id
    @PatchMapping("/api/products/{id}")
    Product patch(@RequestBody Map<String, String> update, @PathVariable Long id){
        try {
            Product product = repository.findOne(id);

            String author = update.get("author");
            if (!StringUtils.isEmpty(author)){
                product.setAuthor(author);

                return repository.save(product);
            }else {
                throw new BookUnSupportedFieldPatchException(update.keySet());
            }
        }catch (Exception e){
            throw new BookNotFoundException(id);
        }
    }

    @DeleteMapping("/api/products/{id}")
    void deleteBook(@PathVariable Long id){
        repository.delete(id);
    }

    @DeleteMapping("/api/products")
    void deleteAll(){
        repository.deleteAll();
    }
}
