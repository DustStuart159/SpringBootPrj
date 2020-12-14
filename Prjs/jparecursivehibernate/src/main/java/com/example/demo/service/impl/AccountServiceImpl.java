package com.example.demo.service.impl;

import com.example.demo.models.Accounts;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.IAccountService;
import com.example.demo.service.dto.AccountDTO;
import com.example.demo.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private final IAccountRepository accRepo;
    private final AccountMapper accMapper;
    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        Accounts account = accRepo.save(accMapper.convertToEntity(accountDTO));

        return accMapper.convertToDTO(account);
    }

    @Override
    public Set<AccountDTO> findAll() {
        Set<AccountDTO> set = new HashSet<>();

        for (Accounts account : accRepo.findAll()){
            set.add(accMapper.convertToDTO(account));
        }

        return set;
    }
}
