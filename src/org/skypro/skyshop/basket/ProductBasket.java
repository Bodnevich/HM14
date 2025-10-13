package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

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
        int specialCount = 0;
        int totalCost = 0;

        if (isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.toString());
                totalCost += product.getProductPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " +specialCount);
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
        return size == 0;
    }
}
