package com.stuart.hibernate.moduls;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "bank_account")
@Data
public class BankAccountInfo {
    @Id
    private Long id;
    private String full_name;
    private double balance;
}
