package com.example.demo.service.dto;

import com.example.demo.models.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContactDTO {
    private long id;
    private String contact_name;
    private Long user_id;
    private UserDTO user;
}
