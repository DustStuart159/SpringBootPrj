package com.example.demo.service.mapper;

import com.example.demo.models.Roles;
import com.example.demo.models.Users;
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

    public RoleDTO convertToDTO(Roles input) {
        RoleDTO res = super.tranferData(input, RoleDTO.class);

        for (UserDTO userDTO : res.getUsers()){
            userDTO.setRoles(new HashSet<>());
        }

        return res;
    }

    public Roles convertToEntity(RoleDTO input) {
        Roles res = super.tranferData(input, Roles.class);

        res.setUsers(this.getSetDataByIds(input.getUser_ids(), userRepo, Users.class));

        return res;
    }
    /*private void updateRelationTable(Roles res) {
        for (Users user:res.getUsers()){
            user.getRoles().add(res);
            userRepo.save(user);
        }
    }

    private Set<Users> getUserById(List<Long> ids) {
        Set<Users> list = new HashSet<>();

        for (long id : ids) {
            Optional<Users> opt = userRepo.findById(id);
            if (opt.isPresent()) {
                list.add(opt.get());
            } else {
                System.err.println("Không tìm thấy user có id là " + id);
            }
        }

        return list;
    }*/
}
