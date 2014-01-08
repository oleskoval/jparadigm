package com.sunny.rose.service;

import com.sunny.rose.common.Util;
import com.sunny.rose.domains.engine.Article;
import com.sunny.rose.domains.engine.Category;
import com.sunny.rose.domains.engine.MenuLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A JPA-based implementation of the Showcase Service.
 * 08.02.12  23:16
 */

@Service("showcaseService")
@Repository
public class JpaShowcaseService implements ShowcaseService, Serializable
{
    private static final long serialVersionUID = 2L;
    private final static Logger logger = LoggerFactory.getLogger(JpaShowcaseService.class);
    private  List<Article> firstCategoryArticles = new ArrayList<Article>();

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em)
    {
        this.em = em;
    }

    @Transactional
    public List<Category> findAllCategories()
    {
        System.out.println("!!!!! JpaShowcaseBean findAllCategories()");
        Query query = em.createQuery("select c from Category c order by c.categoryId");
        List<Category> categoriesList = query.getResultList();
        return categoriesList;
    }

    public Category findById(Long id)
    {
        return em.find(Category.class, id);
    }

  public Category findByIdWithArticles(Long id)
    {
        Query query = em.createQuery("select c from Category c join fetch c.articles where c.categoryId = :id order by c.categoryId");
        query.setParameter("id",id);
        Category category = (Category)query.getSingleResult();
        return category;
    }

    public List<Category> findAllCategoriesAndFirstCategoryArticles()
    {
        Query query = em.createQuery("select c from Category c order by c.categoryId");
        List<Category> categoriesList = query.getResultList();


        if(categoriesList != null && categoriesList.size() > 0)
        {
            long categoryId = categoriesList.get(0).getCategoryId();
            Category firstCategory = findByIdWithArticles(categoryId);
             firstCategoryArticles =  Util.convertSet(firstCategory.getArticles());
        }
        return  categoriesList;
    }

    public List<Article> getFirstCategoryArticles()
    {
         return firstCategoryArticles;
    }

    @Transactional
    public List<Article> findArticlesByCategory(Category category)
    {
        System.out.println("!!!!! JpaShowcaseBean findAllCategories()");
        Query query = em.createQuery("select a from Article a where a.articleCategory = :category order by a.articleId");
        query.setParameter("category", category);
        List<Article> articles = query.getResultList();
        return articles;
    }

    public List<MenuLink> getLeftMenuLinks()
    {
        Query query = em.createQuery("select ml from MenuLink ml order by ml.menuLinkId");
        List<MenuLink> leftMenuLinks = query.getResultList();
        return leftMenuLinks;
    }

//    @Transactional
//    public List<Article> findArticlesByCategory(ShowcaseBean showcaseBean)
//    {
//        System.out.println("!!!!! JpaShowcaseBean findArticlesByCategory()");
//        Query query = em.createQuery("select a from Article a where a.articleCategory = :category order by a.articleId");
//        Category category = showcaseBean.getChosenCategory();
//        query.setParameter("category", category);
//        List<Article> articles = query.getResultList();
//        return articles;
//    }
    


}
