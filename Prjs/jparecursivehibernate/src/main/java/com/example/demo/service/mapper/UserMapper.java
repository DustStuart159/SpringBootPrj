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
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserMapper extends BaseMapper {
    private final IRoleRepository roleRepo;
    private final IContactRepository contactRepo;

    public UserDTO convertToDto(Users input) {
        UserDTO output = super.tranferData(input, UserDTO.class);

        for (ContactDTO contactDTO : output.getContacts()){
            contactDTO.setUser(null);
        }
        for (RoleDTO roleDTO : output.getRoles()){
            roleDTO.setUsers(new HashSet<>());
        }

        return output;
    }

    public Users convertToEntity(UserDTO input) {
        Users res = super.tranferData(input, Users.class);

        res.setRoles(this.getSetDataByIds(input.getRole_ids(), roleRepo, Roles.class));
        res.setContacts(this.getSetDataByIds(input.getContact_ids(), contactRepo, Contacts.class));
        /*res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setUser(this.getUserById(input.getUser_id()));
        this.updateRelationTable(res);*/

        return res;
    }

    /*private void updateRelationTable(Users res) {
        Users user = res.getUser();
        if (null == user) return;

        user.getOrders().add(res);
        userRepo.save(user);
    }

    private Users getUserById(Long id) {
        if (null == id) return null;

        Optional<Users> opt = userRepo.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            System.err.println("Không tồn tại user có id là " + id);
            return null;
        }
    }*/
}
