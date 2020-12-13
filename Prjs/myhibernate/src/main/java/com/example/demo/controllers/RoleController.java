package com.example.demo.controllers;

import com.example.demo.service.dto.RoleDTO;
import com.example.demo.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {
    private final RoleServiceImpl roleService;

    @PostMapping("/create")
    public RoleDTO save(@RequestBody RoleDTO dto){
        return roleService.save(dto);
    }

    @GetMapping("/find-all")
    public Set<RoleDTO> findAll(){
        return roleService.findAll();
    }
}
