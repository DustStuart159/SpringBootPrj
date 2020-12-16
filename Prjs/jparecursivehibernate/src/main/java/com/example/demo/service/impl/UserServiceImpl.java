package com.example.demo.service.impl;

import com.example.demo.models.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
import com.example.demo.service.dto.UserDTO;
import com.example.demo.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepo;
    private final UserMapper userMapper;

    @Override
    public UserDTO save(UserDTO roleDTO) {
        Users order = userRepo.save(userMapper.convertToEntity(roleDTO));

        return userMapper.convertToDto(order);
    }

    @Override
    public Set<UserDTO> findAll() {
        Set<UserDTO> set = new HashSet<>();

        for (Users user : userRepo.findAll()) {
            set.add(userMapper.convertToDto(user));
        }

        return set;
    }
}
