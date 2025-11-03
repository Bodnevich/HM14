package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProductBasket product = new ProductBasket();

        product.totalCost();

        SearchEngine engine = new SearchEngine();

        engine.add(new FixPriceProduct("Спагетти"));
        engine.add(new DiscountedProduct("Сливки", 150, 13));
        engine.add(new SimpleProduct("Курица", 385));
        engine.add(new FixPriceProduct("Грибы"));
        engine.add(new DiscountedProduct("Пармезан", 420, 38));
        engine.add(new SimpleProduct("Черри", 109));

        engine.add(new Article("История Спагетти", "Из Италии пришло блюдо."));
        engine.add(new Article("Итальянская кухня", "Рассказ о лучших итальянских блюдах."));
        engine.add(new Article("Сыр пармезан", "Самый известный сыр Италии."));

        Map<String, Searchable> results = engine.findAllMatching("Пармезан");
        System.out.println("\nРезультаты поиска по запросу: ");
        for (Map.Entry<String, Searchable> result : results.entrySet()) {
            System.out.println(result.getValue().getStringRepresentation());
        }
    }
}
