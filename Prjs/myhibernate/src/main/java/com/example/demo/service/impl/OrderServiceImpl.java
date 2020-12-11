package com.example.demo.service.impl;

import com.example.demo.models.Orders;
import com.example.demo.models.Products;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.service.IOrderService;
import com.example.demo.service.dto.OrderDTO;
import com.example.demo.service.dto.ProductDTO;
import com.example.demo.service.mapper.OrderMapper;
import com.example.demo.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final IOrderRepository iOrderRepository;
    private final OrderMapper mapper = new OrderMapper();

    public List<OrderDTO> finAll(){
        List<OrderDTO> listDTO = new ArrayList<>();

        List<Orders> list = iOrderRepository.findAll();

        for (Orders order : list){
            listDTO.add(mapper.convertToDTO(order));
        }

        return listDTO;
    }

    public Optional<Orders> findById(Long id){
        return iOrderRepository.findById(id);
    }

    public OrderDTO save(OrderDTO orderDTO){
        Orders order = iOrderRepository.save(mapper.convertToEntity(orderDTO));
        return mapper.convertToDTO(order);
    }
    public void deleteById(Long id)
    {
        iOrderRepository.deleteById(id);
    }
}
