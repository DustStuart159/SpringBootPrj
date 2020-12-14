package com.example.demo.service.mapper;

import com.example.demo.models.Users;
import com.example.demo.service.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserMapper extends BaseMapper {

    public UserDTO convertToDto(Users input) {
        UserDTO res = super.tranferData(input, new UserDTO());

        /*res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setUser(input.getUser());*/

        return res;
    }

    public Users convertToEntity(UserDTO input) {
        Users res = super.tranferData(input, new Users());

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
