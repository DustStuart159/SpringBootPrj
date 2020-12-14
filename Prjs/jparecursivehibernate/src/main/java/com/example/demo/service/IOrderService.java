package com.example.demo.service;

import com.example.demo.service.dto.UserDTO;

import java.util.Set;

public interface IOrderService {
    UserDTO save(UserDTO roleDTO);
    Set<UserDTO> findAll();
}
