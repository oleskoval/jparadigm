package com.sunny.rose.domains.engine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/** 08.02.12  0:01 */

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable
{

    private static final long serialVersionUID = 4011346719502657799L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @Column(unique = true)
    private String categoryName;

    @Column(length =1500)
    private String categoryIntroduction;

    @OneToMany(targetEntity = Article.class,cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Article> articles;

    public Category(Long categoryId, String categoryName)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category()
    {
    }

    public Long getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public Set<Article> getArticles()
    {
        return articles;
    }

    public void setArticles(Set<Article> articles)
    {
        this.articles = articles;
    }

    public String getCategoryIntroduction()
    {
        return categoryIntroduction;
    }

    public void setCategoryIntroduction(String categoryIntroduction)
    {
        this.categoryIntroduction = categoryIntroduction;
    }

    @Override
    public String toString()
    {
        return categoryName;
    }
}
