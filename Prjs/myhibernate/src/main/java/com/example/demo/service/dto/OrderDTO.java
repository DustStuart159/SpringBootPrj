package com.example.demo.service.dto;

import com.example.demo.models.Orders;
import com.example.demo.models.Roles;
import com.example.demo.models.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderDTO {
    private long id;
    private String order_name;
    private Long user_id;
    private Users user;
}
