package com.example.demo.service.mapper;

import com.example.demo.models.Contacts;
import com.example.demo.models.Roles;
import com.example.demo.models.Users;
import com.example.demo.repository.IContactRepository;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.dto.RoleDTO;
import com.example.demo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleMapper extends BaseMapper {
    private final IUserRepository userRepo;
    private final IContactRepository contactRepo;

    public RoleDTO convertToDTO(Roles input) {
        RoleDTO output = super.tranferData(input, RoleDTO.class);

        return output;
    }

    public Roles convertToEntity(RoleDTO input) {
        Roles output = super.tranferData(input, Roles.class);

        /*output.setUser(this.getDataById(input.getUser_id(), userRepo, Users.class));
        output.setContact(this.getDataById(input.getContact_id(), contactRepo, Contacts.class));*/

        return output;
    }
}
