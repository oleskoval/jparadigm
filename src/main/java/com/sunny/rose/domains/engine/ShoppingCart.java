package com.sunny.rose.domains.engine;

import com.sunny.rose.domains.enterprise.WebUser;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SHOPPING_CARTS")
public class ShoppingCart
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdDate;

    @OneToOne
    @JoinColumn(name = "WEB_USER_ID",nullable = true)
    private WebUser webUser;

    @OneToMany(mappedBy = "shoppingCart", 
            cascade = CascadeType.ALL)
    @IndexColumn(name = "LINE_ITEM_POSITION")
    private List<LineItem> lineItems;
    
    public WebUser getWebUser()
    {
        return webUser;
    }

    public void setWebUser(WebUser webUser)
    {
        this.webUser = webUser;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<LineItem> getLineItems()
    {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems)
    {
        this.lineItems = lineItems;
    }
}
