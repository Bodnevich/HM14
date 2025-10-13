package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main (String[] args) {
        ProductBasket product = new ProductBasket();

        product.addProduct(new FixPriceProduct("Спагетти"));
        product.addProduct(new DiscountedProduct("Сливки", 150, 13));
        product.addProduct(new SimpleProduct("Курица", 385));
        product.addProduct(new FixPriceProduct("Грибы"));
        product.addProduct(new DiscountedProduct("Пармезан", 420, 38));
        product.addProduct(new SimpleProduct("Черри", 109));

        product.printBasket();

        product.totalCost();
        System.out.println("Стоимость корзины: " + product.totalCost());

        System.out.println("Есть в корзине Молоко? " + product.productSearch("Молоко"));

        System.out.println("Есть в корзине Сливки? " + product.productSearch("Сливки"));

        product.clearBasket();

        product.printBasket();

        product.totalCost();

        product.productSearch("Грибы");

        SearchEngine engine = new SearchEngine(10);

        engine.add(new FixPriceProduct("Спагетти"));
        engine.add(new DiscountedProduct("Сливки", 150, 13));
        engine.add(new SimpleProduct("Курица", 385));
        engine.add(new FixPriceProduct("Грибы"));
        engine.add(new DiscountedProduct("Пармезан", 420, 38));
        engine.add(new SimpleProduct("Черри", 109));

        engine.add(new Article("История Спагетти", "Из Италии пришло блюдо."));
        engine.add(new Article("Итальянская кухня", "Рассказ о лучших итальянских блюдах."));
        engine.add(new Article("Сыр пармезан", "Самый известный сыр Италии."));

        try {
            Product invalidProduct = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Product zeroPriceProduct = new SimpleProduct("Грибы", 0);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); //
        }

        try {
            Product minusBasePriceProduct = new DiscountedProduct("Сыр", -100, 10);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Product tooHighDiscountProduct = new DiscountedProduct("Хлеб", 100, 110);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            Searchable mostRelevant = engine.findMostRelevant("Италия");
            System.out.println(mostRelevant.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }

        try {
            Searchable noResults = engine.findMostRelevant("Французские вина"); // Запрос, которого нет
            System.out.println(noResults.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }
    }
}
