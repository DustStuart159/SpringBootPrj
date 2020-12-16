package com.example.demo.service.dto;

import com.example.demo.models.Contacts;
import com.example.demo.models.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RoleDTO {
    private long id;
    private String role_name;
    private Long user_id;
    private UserDTO user;
    private Long contact_id;
    private ContactDTO contact;
}
