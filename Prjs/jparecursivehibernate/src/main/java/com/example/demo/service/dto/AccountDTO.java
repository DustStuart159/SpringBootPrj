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
public class AccountDTO {
    private long id;
    private String account_name;
    private Long user_id;
    private Users user;
}
