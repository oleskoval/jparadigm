package com.sunny.rose.domains.engine;

import com.sunny.rose.domains.enterprise.Role;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ENTERPRISE_FLOWS")
public class EnterpriseFlow implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;


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

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }
}
