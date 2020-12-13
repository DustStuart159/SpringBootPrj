package com.example.demo.service;

import com.example.demo.service.dto.RoleDTO;

import java.util.Set;

public interface IRoleService {
    RoleDTO save(RoleDTO roleDTO);
    Set<RoleDTO> findAll();
}
