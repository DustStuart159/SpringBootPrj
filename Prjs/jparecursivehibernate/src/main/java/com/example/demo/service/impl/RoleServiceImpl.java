package com.example.demo.service.impl;

import com.example.demo.models.Roles;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.service.IRoleService;
import com.example.demo.service.dto.RoleDTO;
import com.example.demo.service.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final IRoleRepository roleRepo;
    private final RoleMapper roleMapper;

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        Roles role = roleRepo.save(roleMapper.convertToEntity(roleDTO));

        return roleMapper.convertToDTO(role);
    }

    @Override
    public Set<RoleDTO> findAll() {
        Set<RoleDTO> set = new HashSet<>();

        for (Roles role : roleRepo.findAll()) {
            set.add(roleMapper.convertToDTO(role));
        }

        return set;
    }
}
