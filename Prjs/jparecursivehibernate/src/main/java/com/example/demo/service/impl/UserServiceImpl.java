package com.example.demo.service.impl;

import com.example.demo.models.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IOrderService;
import com.example.demo.service.dto.UserDTO;
import com.example.demo.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IOrderService {
    private final IUserRepository orderRepo;
    private final UserMapper orderMapper;

    @Override
    public UserDTO save(UserDTO roleDTO) {
        Users order = orderRepo.save(orderMapper.convertToEntity(roleDTO));

        return orderMapper.convertToDto(order);
    }

    @Override
    public Set<UserDTO> findAll() {
        Set<UserDTO> set = new HashSet<>();

        for (Users user : orderRepo.findAll()) {
            set.add(orderMapper.convertToDto(user));
        }

        return set;
    }
}
