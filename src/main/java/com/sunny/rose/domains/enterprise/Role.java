package com.sunny.rose.domains.enterprise;

import com.sunny.rose.domains.RoleName;
import com.sunny.rose.domains.engine.EnterpriseFlow;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 The Role entity represents role of every participants inside webflows
 */

@Entity
@Table(name = "ROLES")
public class Role implements Serializable
{

    private static final long serialVersionUID = 4011346719502657780L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(unique = true,nullable = false)
    private RoleName roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<Officer> officers;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REFRESH)
    private Set<EnterpriseFlow> flows;

    public Role()
    {
    }

    public Role(RoleName roleName)
    {
        this.roleName = roleName;
    }

    public Long getId()
    {
        return id;
    }

    public void addOfficer(Officer officer)
    {
        officer.getRoles().add(this);
        officers.add(officer);
    }

    public void setId(Long roleId)
    {
        this.id = roleId;
    }

    public RoleName getRoleName()
    {
        return roleName;
    }

    public void setRoleName(RoleName roleName)
    {
        this.roleName = roleName;
    }

    public Set<Officer> getOfficers()
    {
        return officers;
    }

    public void setOfficers(Set<Officer> officers)
    {
        this.officers = officers;
    }

    public Set<EnterpriseFlow> getFlows()
    {
        return flows;
    }

    public void setFlows(Set<EnterpriseFlow> flows)
    {
        this.flows = flows;
    }
}
