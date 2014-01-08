package com.sunny.rose.domains.enterprise;

import com.sunny.rose.domains.engine.ShoppingCart;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "WEB_USERS")
public class WebUser implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String password;

    @OneToOne(mappedBy = "webUser")
    private ShoppingCart shoppingCart;


    @OneToOne(mappedBy = "webUser")
    private Person person;

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public ShoppingCart getShoppingCart()
    {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart)
    {
        this.shoppingCart = shoppingCart;
    }
}
