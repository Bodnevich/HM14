package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import static sun.util.locale.LocaleUtils.isEmpty;

public class ProductBasket {

    private Product [] products;
    private int size = 0;

    public ProductBasket () {
        this.products = new Product[5];
    }

    public void addProduct (Product product) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить продукт ");
            return;
        }
        products[size++] = product;
    }

    public int totalCost () {
        int totalCost = 0;
        for (Product product : products) {
            if (product != null) {
                totalCost +=product.getProductPrice();
            }
        }
        return totalCost;
    }

    public void printBasket() {
        if (isEmpty()) {
            System.out.println("В козине пусто");
            return;
        }
        for (Product product : products) {
            if (product != null) {
                System.out.printf("%s: %d%n", product.getProductName(), product.getProductPrice());
            }
        }
        System.out.println("Итого: " + totalCost());
    }
    public boolean productSearch (String productName) {
        for (Product product : products) {
            if ((product != null) && product.getProductName().equals(productName)) {
                return  true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        size = 0;
    }

    private boolean isEmpty() {
        return size == 0 || allElementsNull();
    }

    private boolean allElementsNull() {
        for (Product product : products) {
            if (product != null) {
                return false;
            }
        }
        return true;
    }
}
