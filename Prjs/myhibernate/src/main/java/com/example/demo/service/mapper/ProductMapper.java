package com.example.demo.service.mapper;

import com.example.demo.models.Products;
import com.example.demo.service.dto.ProductDTO;

public class ProductMapper {
   /* convert tu entity -->DTO*/
    public ProductDTO convertToDTO(Products input){
        ProductDTO res = new ProductDTO();

        res.setId(input.getId());
        res.setProduct_name(input.getProduct_name());
        res.setCategory(res.getCategory());

        return res;
    }

   /* convert tu DTO --> Entity*/
    public Products convertToEntity(ProductDTO input){
        Products res = new Products();

        res.setId(input.getId());
        res.setProduct_name(input.getProduct_name());
        res.setCategory(res.getCategory());

        return res;
    }
    
}
