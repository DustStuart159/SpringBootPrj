package com.example.demo.service.mapper;

import com.example.demo.models.Accounts;
import com.example.demo.models.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.dto.AccountDTO;
import com.example.demo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountMapper extends BaseMapper{
    private final IUserRepository userRepo;

    public AccountDTO convertToDTO(Accounts input){
        AccountDTO output = super.tranferData(input, new AccountDTO());


        return output;
    }

    public Accounts convertToEntity(AccountDTO input){
        Accounts output = super.tranferData(input, new Accounts());

        output.setUser(this.getDataById(input.getUser_id(), userRepo, new Users()));

        return output;
    }
}
