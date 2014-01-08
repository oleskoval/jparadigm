package com.sunny.rose.domains.engine;

import javax.persistence.*;
import java.io.Serializable;

/** 15.02.12  23:45 */

@Entity
@Table(name = "MENU_LINKS")
public class MenuLink  implements Serializable
{
    private static final long serialVersionUID = 4011346719502658899L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuLinkId;
    
    private String title;
    
    private String pageTitle;

    @OneToOne(optional=false)
    @JoinColumn(name="CATEGORY_ID", unique=true, nullable=false, updatable=false)
    private Category category;

    public Long getMenuLinkId()
    {
        return menuLinkId;
    }

    public void setMenuLinkId(Long menuLinkId)
    {
        this.menuLinkId = menuLinkId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Category getCategory()
    {
        System.out.println("!!!!!!!!!!!!getMenuLinkCategory  " + category);
        return category;
    }

    public void setCategory(Category menuLinkCategory)
    {
        this.category = menuLinkCategory;
    }

    public String getPageTitle()
    {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle)
    {
        this.pageTitle = pageTitle;
    }

    @Override
    public String toString()
    {
        return title;
    }
}
