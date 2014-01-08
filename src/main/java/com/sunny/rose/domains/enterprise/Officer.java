package com.sunny.rose.domains.enterprise;


import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "OFFICERS")
public class Officer  extends Person   implements Serializable
{
    private Date hireDate;

     @ManyToMany
     @JoinTable(name = "OFFICERS_ROLES",
      joinColumns =  {@JoinColumn(name = "OFFICER_ID")},
      inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
     @IndexColumn(name = "ROLE_POSITION")
    private List<Role> roles;

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    public Date getHireDate()
    {
        return hireDate;
    }

    public void setHireDate(Date hireDate)
    {
        this.hireDate = hireDate;
    }
}
