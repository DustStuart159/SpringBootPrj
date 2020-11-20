package com.stuart.hello_rest_db.controllers;

import com.stuart.hello_rest_db.error.BookNotFoundException;
import com.stuart.hello_rest_db.error.BookUnSupportedFieldPatchException;
import com.stuart.hello_rest_db.modul.Product;
import com.stuart.hello_rest_db.modul.ProductRepository;

import jdk.nashorn.internal.runtime.options.Option;
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
        Product product = repository.findOne(id);
        if (null==product){
            throw new BookNotFoundException(id);
        }

        return product;
    }

    // sửa thông tin sách theo id
    @PutMapping("/api/products/{id}")
    Product saveOrUpdate(@RequestBody Product newBook, @PathVariable Long id){
        Product product = repository.findOne(id);
        if (null==product){
            throw new BookNotFoundException(id);
        }else{
            product.setName(newBook.getName());
            product.setAuthor(newBook.getAuthor());
            product.setPrice(newBook.getPrice());

            return product;
        }
    }

    //sửa thông tin author của sách theo id
    @PatchMapping("/api/products/{id}")
    Product patch(@RequestBody Map<String, String> update, @PathVariable Long id){
            Product product = repository.findOne(id);
            if (null==product){
                throw new BookNotFoundException(id);
            }

            String author = update.get("author");
            if (StringUtils.isEmpty(author)){
                throw new BookUnSupportedFieldPatchException(update.keySet());
            }

            product.setAuthor(author);
            return repository.save(product);
    }

    @DeleteMapping("/api/products/{id}")
    void deleteBook(@PathVariable Long id){
        Product product = repository.findOne(id);
        if (null==product){
            throw new BookNotFoundException(id);
        }
        
        repository.delete(id);
    }

    @DeleteMapping("/api/products")
    void deleteAll(){
        repository.deleteAll();
    }
}
