package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable  {
    private final String article;
    private final String textArticle;

    public Article(String article, String textArticle) {
        this.article = article;
        this.textArticle = textArticle;
    }

    public String getArticle() {
        return article;
    }

    public String getTextArticle() {
        return textArticle;
    }

    @Override
    public String getSearchTerm() {
        return article + " " + textArticle;
    }

    @Override
    public String getContentType() {
        return "Article";
    }

    @Override
    public String getObjectName() {
        return article;
    }

    @Override
    public String getStringRepresentation() {
        return article + " — " + getContentType();
    }

    @Override
    public  String toString() {
        return article + "\n" + textArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article1 = (Article) o;
        return Objects.equals(article, article1.article);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(article);
    }
}
