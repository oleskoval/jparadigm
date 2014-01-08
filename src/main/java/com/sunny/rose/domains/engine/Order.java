package com.sunny.rose.domains.engine;

import com.sunny.rose.domains.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Date orderedDate;

    private Date shippedDate;

    private OrderStatus orderStatus;

     @OneToMany(mappedBy = "order")
    private Set<LineItem> lineItems;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getOrderedDate()
    {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate)
    {
        this.orderedDate = orderedDate;
    }

    public Date getShippedDate()
    {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate)
    {
        this.shippedDate = shippedDate;
    }

    public OrderStatus getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public Set<LineItem> getLineItems()
    {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems)
    {
        this.lineItems = lineItems;
    }
}
