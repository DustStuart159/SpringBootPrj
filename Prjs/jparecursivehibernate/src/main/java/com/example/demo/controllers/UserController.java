package com.example.demo.controllers;

import com.example.demo.service.dto.UserDTO;
import com.example.demo.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/create")
    public UserDTO save(@RequestBody UserDTO dto){
        return userService.save(dto);
    }

    @GetMapping("/get-all")
    @Transactional
    public Set<UserDTO> findAll(){
        return userService.findAll();
    }
}
