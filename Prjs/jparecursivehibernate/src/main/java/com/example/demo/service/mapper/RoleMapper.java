package com.example.demo.service.mapper;

import com.example.demo.models.Roles;
import com.example.demo.service.dto.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleMapper extends BaseMapper {

    public RoleDTO convertToDTO(Roles input) {
        RoleDTO output = super.tranferData(input, RoleDTO.class);

        return output;
    }

    public Roles convertToEntity(RoleDTO input) {
        Roles output = super.tranferData(input, Roles.class);

        return output;
    }
}
