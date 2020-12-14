package com.example.demo.service.dto;

import com.example.demo.models.Accounts;
import com.example.demo.models.Contacts;
import com.example.demo.models.Roles;
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
    private Set<Roles> roles = new HashSet<>();
    private List<Long> account_ids;
    private Set<Accounts> accounts = new HashSet<>();
    private List<Long> contact_ids;
    private Set<Contacts> contacts = new HashSet<>();
}
