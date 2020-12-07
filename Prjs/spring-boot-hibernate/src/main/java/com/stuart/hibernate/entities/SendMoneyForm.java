package com.stuart.hibernate.entities;

import lombok.Data;

import javax.persistence.*;

@Data
public class SendMoneyForm {
    private Long fromAccount;
    private Long toAccount;
    private Double amount;

    public SendMoneyForm(long fromAccount, long toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }
}
