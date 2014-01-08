package com.sunny.rose.domains.enterprise;

import com.sunny.rose.domains.engine.Account;

import javax.persistence.*;
import java.io.Serializable;

/** 29.01.12  17:43 */

@Entity
@Table(name = "CUSTOMERS")
public class Customer extends Person implements Serializable
{

    private static final long serialVersionUID = 4011346719502657778L;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    @Override
    public String toString()
    {
        return this.getId() + " " + this.getFirstName();
    }
}
