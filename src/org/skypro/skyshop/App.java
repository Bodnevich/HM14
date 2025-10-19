package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket product = new ProductBasket();

        product.addProduct(new FixPriceProduct("Спагетти"));
        product.addProduct(new DiscountedProduct("Сливки", 150, 13));
        product.addProduct(new SimpleProduct("Курица", 385));
        product.addProduct(new FixPriceProduct("Грибы"));
        product.addProduct(new DiscountedProduct("Пармезан", 420, 38));
        product.addProduct(new SimpleProduct("Черри", 109));

        product.printBasket();

        List<Product> deletedProducts = product.removeProductsByName("Черри");
        System.out.println("\nУдаленные продукты из списка: ");
        for (Product p : deletedProducts) {
            System.out.println(p);
        }

        product.printBasket();

        deletedProducts = product.removeProductsByName("Яблоко");
        if (deletedProducts.isEmpty()) {
            System.out.println("\nСписок удаленных продуктов пуст.");
        }

        product.printBasket();

        product.totalCost();
        System.out.println("Стоимость корзины: " + product.totalCost());

        System.out.println("Есть в корзине Молоко? " + product.productSearch("Молоко"));

        System.out.println("Есть в корзине Сливки? " + product.productSearch("Сливки"));

        product.clearBasket();

        product.printBasket();

        product.totalCost();

        product.productSearch("Грибы");

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

        List<Searchable> results = engine.findAllMatching("Пармезан");
        System.out.println("\nРезультаты поиска по запросу: ");
        for (Searchable result : results) {
            System.out.println(result.getStringRepresentation());
        }
    }
}
