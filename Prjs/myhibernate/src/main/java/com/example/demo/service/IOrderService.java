package com.example.demo.service;

import com.example.demo.service.dto.OrderDTO;

import java.util.Set;

public interface IOrderService {
    OrderDTO save(OrderDTO roleDTO);
    Set<OrderDTO> findAll();
}
