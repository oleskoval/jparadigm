package com.sunny.rose.domains.engine;

import com.sunny.rose.domains.enterprise.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    @OneToMany
    @JoinTable(name = "ACCOUNT_ADDRESSES",
                        joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
                        inverseJoinColumns = @JoinColumn(name = "BILLING_ADDRESS_ID"))
    private Set<Address> billingAddresses;

    public Set<Address> getBillingAddresses()
    {
        return billingAddresses;
    }

    public void setBillingAddresses(Set<Address> billingAddresses)
    {
        this.billingAddresses = billingAddresses;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
