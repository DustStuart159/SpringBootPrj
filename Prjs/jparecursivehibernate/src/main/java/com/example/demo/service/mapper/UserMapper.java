package com.example.demo.service.mapper;

import com.example.demo.models.Users;
import com.example.demo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper extends BaseMapper {

    public UserDTO convertToDto(Users input) {
        UserDTO output = this.tranferData(input, UserDTO.class);

        return output;
    }

    public Users convertToEntity(UserDTO input) {
        Users output = this.tranferData(input, Users.class);

        return output;
    }
}
