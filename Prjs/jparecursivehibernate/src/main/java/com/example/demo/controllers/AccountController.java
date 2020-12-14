package com.example.demo.controllers;

import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.dto.AccountDTO;
import com.example.demo.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl accService;

    @PostMapping("/create")
    public AccountDTO save(@RequestBody AccountDTO accountDTO){
        return accService.save(accountDTO);
    }

    @GetMapping("/get-all")
    public Set<AccountDTO> findAll(){
        return accService.findAll();
    }
}
