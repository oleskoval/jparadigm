package com.sunny.rose.domains.enterprise;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *The Person entity represents the general person as reflection of any web flow participant
 */

@Entity
@Table(name = "PERSONS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable
{

    private static final long serialVersionUID = 4011346719502657779L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String secondName;
    private Date birthday;


    @OneToOne
    @JoinColumn(name = "WEB_USER_ID")
    private WebUser webUser;



    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

   public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSecondName()
    {
        return secondName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }



    public WebUser getWebUser()
    {
        return webUser;
    }

    public void setWebUser(WebUser webUser)
    {
        this.webUser = webUser;
    }


}
