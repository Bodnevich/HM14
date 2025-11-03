package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        ProductBasket product = new ProductBasket();

        product.totalCost();

        SearchEngine engine = new SearchEngine();

        product.addProduct(new FixPriceProduct("Спагетти"));
        product.addProduct(new DiscountedProduct("Сливки", 150, 13));
        product.addProduct(new SimpleProduct("Курица", 385));
        product.addProduct(new FixPriceProduct("Грибы"));
        product.addProduct(new DiscountedProduct("Пармезан", 420, 38));
        product.addProduct(new SimpleProduct("Черри", 109));

        engine.add(new FixPriceProduct("Спагетти"));
        engine.add(new DiscountedProduct("Сливки", 150, 13));
        engine.add(new SimpleProduct("Курица", 385));
        engine.add(new FixPriceProduct("Грибы"));
        engine.add(new DiscountedProduct("Пармезан", 420, 38));
        engine.add(new SimpleProduct("Черри", 109));

        engine.add(new Article("История Спагетти", "Из Италии пришло блюдо."));
        engine.add(new Article("Итальянская кухня", "Рассказ о лучших итальянских блюдах."));
        engine.add(new Article("Сыр пармезан", "Самый известный сыр Италии."));

        Set<Searchable> results = engine.findAllMatching("Пармезан");
        System.out.println("\nРезультаты поиска по запросу: ");
        for (Searchable result : results) {
            System.out.println(result.getStringRepresentation());
        }

        System.out.println("\nОбщая стоимость товаров в корзине: " + product.totalCost());
    }
}
