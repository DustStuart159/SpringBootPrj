package com.example.demo.service;

import com.example.demo.service.dto.UserDTO;

import java.util.List;
import java.util.Set;

public interface IUserService {
    UserDTO save(UserDTO roleDTO);
    Set<UserDTO> findAll();
}
