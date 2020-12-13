package com.example.demo.service.impl;

import com.example.demo.models.Orders;
import com.example.demo.models.Roles;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.service.IOrderService;
import com.example.demo.service.IRoleService;
import com.example.demo.service.dto.OrderDTO;
import com.example.demo.service.dto.RoleDTO;
import com.example.demo.service.mapper.OrderMapper;
import com.example.demo.service.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final IOrderRepository orderRepo;
    private final OrderMapper orderMapper;

    @Override
    public OrderDTO save(OrderDTO roleDTO) {
        Orders order = orderRepo.save(orderMapper.convertToEntity(roleDTO));

        return orderMapper.convertToDto(order);
    }

    @Override
    public Set<OrderDTO> findAll() {
        Set<OrderDTO> set = new HashSet<>();

        for (Orders order : orderRepo.findAll()) {
            set.add(orderMapper.convertToDto(order));
        }

        return set;
    }
}
