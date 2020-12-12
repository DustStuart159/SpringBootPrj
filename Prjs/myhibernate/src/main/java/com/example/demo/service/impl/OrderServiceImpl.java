package com.example.demo.service.impl;

import com.example.demo.models.Orders;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.service.dto.OrderDTO;
import com.example.demo.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl {
    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private OrderMapper mapper;

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
