package com.example.demo.service.mapper;

import com.example.demo.models.Contacts;
import com.example.demo.models.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.dto.ContactDTO;
import com.example.demo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMapper extends BaseMapper{
    private final IUserRepository userRepo;
    public ContactDTO convertToDTO(Contacts input){
        ContactDTO output = this.tranferData(input, new ContactDTO());


        return output;
    }

    public Contacts convertToEntity(ContactDTO input){
        Contacts output = this.tranferData(input, new Contacts());

        output.setUser(this.getDataById(input.getUser_id(), userRepo, new Users()));

        return output;
    }
}
