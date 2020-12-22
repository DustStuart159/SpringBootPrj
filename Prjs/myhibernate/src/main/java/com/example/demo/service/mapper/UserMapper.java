package com.example.demo.service.mapper;

import com.example.demo.models.Roles;
import com.example.demo.models.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.dto.RoleDTO;
import com.example.demo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserMapper {
    private final IUserRepository userRepo;

    public UserDTO convertToDto(Users input) {
        UserDTO res = new UserDTO();

        res.setId(input.getId());
        res.setUser_name(input.getUser_name());
        res.setOrders(input.getOrders());
        res.setRoles(input.getRoles());

        return res;
    }

    public Users convertToEntity(UserDTO input) {
        Users res = new Users();

        res.setId(input.getId());
        res.setUser_name(input.getUser_name());
        res.setOrders(input.getOrders());
        res.setRoles(input.getRoles());

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
