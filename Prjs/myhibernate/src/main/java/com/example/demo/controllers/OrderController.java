package com.example.demo.controllers;

import com.example.demo.service.dto.OrderDTO;
import com.example.demo.service.dto.RoleDTO;
import com.example.demo.service.impl.OrderServiceImpl;
import com.example.demo.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderServiceImpl orderService;

    @PostMapping("/create")
    public OrderDTO save(@RequestBody OrderDTO dto){
        return orderService.save(dto);
    }

    @GetMapping("find-all")
    public Set<OrderDTO> findAll(){
        return orderService.findAll();
    }
}
