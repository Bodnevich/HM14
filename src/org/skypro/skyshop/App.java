package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main (String[] args) {
        ProductBasket product = new ProductBasket();

        product.addProduct(new Product("Спагетти", 100));
        product.addProduct(new Product("Сливки", 150));
        product.addProduct(new Product("Курица", 385));
        product.addProduct(new Product("Грибы", 200));
        product.addProduct(new Product("Пармезан", 420));
        product.addProduct(new Product("Черри", 109));

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
