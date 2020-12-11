package com.example.demo.service.mapper;

import com.example.demo.models.Categories;
import com.example.demo.models.Orders;
import com.example.demo.service.dto.CategoryDTO;
import com.example.demo.service.dto.OrderDTO;
import com.example.demo.service.impl.CategoryServiceImpl;

public class CategoryMapper {
   /* convert tu entity -->DTO*/
    public CategoryDTO convertToDTO(Categories input){
        CategoryDTO res = new CategoryDTO();

        res.setId(input.getId());
        res.setCategory_name(input.getCategory_name());
        res.setProducts(input.getProducts());

        return res;
    }

   /* convert tu DTO --> Entity*/
    public Categories convertToEntity(CategoryDTO input){
        Categories res = new Categories();

        res.setId(input.getId());
        res.setCategory_name(input.getCategory_name());
        res.setProducts(input.getProducts());

        return res;
    }
    
}
