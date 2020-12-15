package com.example.demo.service.dto;

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
public class UserDTO {
    private long id;
    private String user_name;
    private List<Long> role_ids;
    private Set<RoleDTO> roles = new HashSet<>();
    private Set<ContactDTO> contacts = new HashSet<>();
}
