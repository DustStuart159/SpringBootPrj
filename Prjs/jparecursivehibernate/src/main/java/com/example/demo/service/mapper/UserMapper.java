package com.example.demo.service.mapper;

import com.example.demo.models.Contacts;
import com.example.demo.models.Roles;
import com.example.demo.models.Users;
import com.example.demo.repository.IContactRepository;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.service.dto.ContactDTO;
import com.example.demo.service.dto.RoleDTO;
import com.example.demo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserMapper extends BaseMapper {
    private final IContactRepository contactRepo;
    private final IRoleRepository roleRepo;

    public UserDTO convertToDto(Users input) {
        UserDTO output = this.tranferData(input, UserDTO.class);

        return output;
    }

    public Users convertToEntity(UserDTO input) {
        Users output = this.tranferData(input, Users.class);

        /*output.setContact(this.getDataById(input.getContact_id(), contactRepo, Contacts.class));
        output.setRole(this.getDataById(input.getRole_id(), roleRepo, Roles.class));*/

        return output;
    }
}
