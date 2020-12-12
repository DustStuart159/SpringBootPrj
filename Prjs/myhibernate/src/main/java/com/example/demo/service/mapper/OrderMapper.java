package com.example.demo.service.mapper;

import com.example.demo.models.Orders;
import com.example.demo.service.dto.OrderDTO;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderMapper {
   /* convert tu entity -->DTO*/
    public OrderDTO convertToDTO(Orders input){
        OrderDTO res = new OrderDTO();

        res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setProducts(input.getProducts());

        return res;
    }

   /* convert tu DTO --> Entity*/
    public Orders convertToEntity(OrderDTO input){
        Orders res = new Orders();

        res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setProducts(input.getProducts());

        return res;
    }
    
}
