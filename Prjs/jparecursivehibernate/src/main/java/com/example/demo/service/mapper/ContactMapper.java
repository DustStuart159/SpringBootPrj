package com.example.demo.service.mapper;

import com.example.demo.models.Contacts;
import com.example.demo.models.Roles;
import com.example.demo.models.Users;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.dto.ContactDTO;
import com.example.demo.service.dto.RoleDTO;
import com.example.demo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class ContactMapper extends BaseMapper {
    private final IUserRepository userRepo;
    private final IRoleRepository roleRepo;

    public ContactDTO convertToDTO(Contacts input) {
        ContactDTO output = this.tranferData(input, ContactDTO.class);

        this.configDisplayInfo(output, ContactDTO.class);

        return output;
    }

    public Contacts convertToEntity(ContactDTO input) {
        Contacts output = this.tranferData(input, Contacts.class);

        return output;
    }
}
