package com.sunny.rose.service;

import com.sunny.rose.domains.engine.Article;
import com.sunny.rose.domains.engine.Category;
import com.sunny.rose.domains.engine.MenuLink;

import java.util.List;

/** 08.02.12  23:16 */

public interface ShowcaseService
{
    List<Category> findAllCategories();
    Category findById(Long id);
    Category findByIdWithArticles(Long id);
    List<Category> findAllCategoriesAndFirstCategoryArticles();
    List<Article> getFirstCategoryArticles();
    List<Article> findArticlesByCategory(Category category);
    List<MenuLink> getLeftMenuLinks();
}
