package com.stuart.hello_rest_db.controllers;

import com.stuart.hello_rest_db.error.BookNotFoundException;
import com.stuart.hello_rest_db.error.BookUnSupportedFieldPatchException;
import com.stuart.hello_rest_db.modul.Entities.ProductEntity;
import com.stuart.hello_rest_db.modul.ProductRepository;
import com.stuart.hello_rest_db.modul.Entities.SuccessEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api")
public class RestController {
    @Autowired
    private ProductRepository repository;

    // Tìm tất cả sách trong repository
    @GetMapping("/products")
    @ApiOperation(value = "Get All ProductEntity", produces = "application/json")
    List<ProductEntity> findAll(){
        return repository.findAll();
    }

    // Thêm sách vào repository
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/products")
    @ApiOperation(value = "Save new ProductEntity", produces = "application/json")
    ProductEntity newBook(@RequestBody ProductEntity newBook){
        return repository.save(newBook);
    }

    // Tìm product theo id
    @GetMapping("/products/{id}")
    @ApiOperation(value = "Search ProductEntity by Id", produces = "application/json")
    ProductEntity findOne(
            @ApiParam(name = "Id",
                    value = "The Id of the ProductEntity to be viewed",
                    required = true)
            @PathVariable Long id){
        ProductEntity product = repository.findById(id).get();
        if (null==product){
            throw new BookNotFoundException(id);
        }

        return product;
    }

    // sửa thông tin sách theo id
    @PutMapping("/products/{id}")
    @ApiOperation(value = "Modify ProductEntity by Id", produces = "application/json")
    ProductEntity saveOrUpdate(
            @ApiParam(name = "Request Message",
                    value = "The information of the ProductEntity to be modified",
                    required = true)
            @RequestBody ProductEntity newProduct,

            @ApiParam(name = "Id",
                    value = "The Id of the ProductEntity to be modified",
                    required = true)
            @PathVariable Long id){
        ProductEntity product = repository.findById(id).get();
        if (null==product){
            throw new BookNotFoundException(id);
        }else{
            product.setName(newProduct.getName());
            product.setAuthor(newProduct.getAuthor());
            product.setPrice(newProduct.getPrice());

            return product;
        }
    }

    //sửa thông tin author của sách theo id
    @PatchMapping("/products/{id}")
    @ApiOperation(value = "Modify Author ProductEntity by Id", produces = "application/json")
    ProductEntity patch(@RequestBody Map<String, String> update,
                        @ApiParam(name = "Id",
                          value = "The Id of the ProductEntity to modify author",
                          required = true)
                  @PathVariable Long id){
            ProductEntity product = repository.findById(id).get();
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

    @DeleteMapping("/products/{id}")
    @ApiOperation(value = "Delete ProductEntity by Id", produces = "application/json")
    SuccessEntity deleteBook(
            @ApiParam(name = "Id",
                    value = "The Id of the ProductEntity to be deleted",
                    required = true)
            @PathVariable Long id){
        ProductEntity product = repository.findById(id).get();
        if (null==product){
            throw new BookNotFoundException(id);
        }
        
        repository.deleteById(id);
        return new SuccessEntity(DateTime.now().toString(),"Deleted ProductEntity.");
    }

    @DeleteMapping("/products")
    @ApiOperation(value = "Delete all Products")
    SuccessEntity deleteAll(){
        repository.deleteAll();
        return new SuccessEntity(DateTime.now().toString(),"Deleted all Products.");
    }
}
