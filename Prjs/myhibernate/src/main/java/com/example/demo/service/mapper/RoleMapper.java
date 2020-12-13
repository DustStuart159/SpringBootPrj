package com.example.demo.service.mapper;

import com.example.demo.models.Roles;
import com.example.demo.models.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.dto.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleMapper {
    private final IUserRepository userRepo;

    public RoleDTO convertToDto(Roles input) {
        RoleDTO res = new RoleDTO();

        res.setId(input.getId());
        res.setRole_name(input.getRole_name());
        res.setUsers(input.getUsers());

        return res;
    }

    public Roles convertToEntity(RoleDTO input) {
        Roles res = new Roles();

        res.setId(input.getId());
        res.setRole_name(input.getRole_name());
        res.setUsers(this.getUserById(input.getUser_ids()));
        this.updateRelationTable(res);

        return res;
    }

    private void updateRelationTable(Roles res) {
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
    }
}
