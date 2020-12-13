package com.example.demo.service.dto;

import com.example.demo.models.Orders;
import com.example.demo.models.Roles;
import com.example.demo.models.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<Long> order_ids;
    private Set<Orders> orders = new HashSet<>();
    private List<Long> role_ids = new ArrayList<>();
    private Set<Roles> roles = new HashSet<>();
}
