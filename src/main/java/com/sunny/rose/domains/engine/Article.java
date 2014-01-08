package com.sunny.rose.domains.engine;

import javax.persistence.*;
import java.io.Serializable;

/** 06.02.12  22:27 */

@Entity
@Table(name = "ARTICLES")
public class Article implements Serializable
{

    private static final long serialVersionUID = 4011346719502657789L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String articleName;
    private String articleDescription;
    private String articleImage;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID", nullable=false)
    private Category category;


    @OneToOne
    private LineItem lineItem;


    public Article()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long articleId)
    {
        this.id = articleId;
    }

    public String getArticleName()
    {
        return articleName;
    }

    public void setArticleName(String articleName)
    {
        this.articleName = articleName;
    }

    public String getArticleDescription()
    {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription)
    {
        this.articleDescription = articleDescription;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public String getArticleImage()
    {
        return articleImage;
    }

    public void setArticleImage(String articleImage)
    {
        this.articleImage = articleImage;
    }

    public LineItem getLineItem()
    {
        return lineItem;
    }

    public void setLineItem(LineItem lineItem)
    {
        this.lineItem = lineItem;
    }
}
