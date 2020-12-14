package com.example.demo.service.dto;

import com.example.demo.models.Roles;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTO {
    private long id;
    private String order_name;
    private Long role_id;
    private Roles role;
}
