package com.example.demo.service.dto;

import com.example.demo.models.Contacts;
import com.example.demo.models.Roles;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    private Long contact_id;
    private ContactDTO contact;
    private Long role_id;
    private RoleDTO role;
}
