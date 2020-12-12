package com.example.demo.service.mapper;


import com.example.demo.models.Categories;
import com.example.demo.models.Orders;
import com.example.demo.models.Products;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IOrderRepository;

import com.example.demo.service.dto.ProductDTO;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProductMapper {
    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private ICategoryRepository iCategoryRepository;
   /* convert tu entity -->DTO*/
    public ProductDTO convertToDTO(Products input){
        ProductDTO res = new ProductDTO();

        //custom DTO
        Categories category = input.getCategory();

        res.setCategory_id(category.getId());
        res.setOrder_ids(this.getOrderIdList(input));

        //mapping entity
        res.setId(input.getId());
        res.setProduct_name(input.getProduct_name());
        res.setCategory(category);

        return res;
    }

    private List<Long> getOrderIdList(Products input) {
        List<Long> res = new ArrayList<>();

        for (Orders order : input.getOrders()){
            res.add(order.getId());
        }

        return res;
    }

    /* convert tu DTO --> Entity*/
    public Products convertToEntity(ProductDTO input){
        Products res = new Products();

        res.setId(input.getId());
        res.setProduct_name(input.getProduct_name());
        res.setCategory(iCategoryRepository.findById(input.getCategory_id()).get());
        res.setOrders(this.getOrderList(input.getOrder_ids()));

        return res;
    }

    private List<Orders> getOrderList(List<Long> order_ids) {
        List<Orders> res = new ArrayList<>();

        for (long order_id : order_ids){
            res.add(iOrderRepository.findById(order_id).get());
        }

        return res;
    }

}
