package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

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
    }
}
