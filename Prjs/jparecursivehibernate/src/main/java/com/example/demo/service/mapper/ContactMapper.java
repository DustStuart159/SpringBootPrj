package com.example.demo.service.mapper;

import com.example.demo.models.Contacts;
import com.example.demo.models.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.dto.ContactDTO;
import com.example.demo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class ContactMapper extends BaseMapper {
    private final IUserRepository userRepo;

    public ContactDTO convertToDTO(Contacts input) {
        ContactDTO output = this.tranferData(input, ContactDTO.class);

        // config User field
        UserDTO userDTO = this.tranferData(input.getUser(), UserDTO.class);
        if (null!=userDTO){
            userDTO.setContacts(new HashSet<>());
        }

        output.setUser(userDTO);

        return output;
    }

    public Contacts convertToEntity(ContactDTO input) {
        Contacts output = this.tranferData(input, Contacts.class);

        output.setUser(this.getDataById(input.getUser_id(), userRepo, Users.class));

        return output;
    }
}
