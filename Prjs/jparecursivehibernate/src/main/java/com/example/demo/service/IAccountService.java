package com.example.demo.service;

import com.example.demo.service.dto.AccountDTO;
import com.example.demo.service.dto.RoleDTO;

import java.util.Set;

public interface IAccountService {
    AccountDTO save(AccountDTO accountDTO);
    Set<AccountDTO> findAll();
}
