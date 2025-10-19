package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private List<Product> products = new ArrayList<>();

    public void addProduct (Product product) {
       products.add(product);
        }

    public int totalCost () {
        int totalCost = 0;
        for (Product product : products) {
                totalCost +=product.getProductPrice();
            }
        return totalCost;
    }

    public void printBasket() {
        int specialCount = 0;
        int totalCost = 0;

        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
                System.out.println(product.toString());
                totalCost += product.getProductPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " +specialCount);
    }
    public boolean productSearch (String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return  true;
            }
        }
        return false;
    }

    public void clearBasket() {
            products.clear();
        }

    private boolean isEmpty() {
        return products.isEmpty();
    }
    public List<Product> removeProductsByName(String name) {
        Iterator<Product> iterator = products.iterator();
        List<Product> removedProduct = new LinkedList<>();

        while (iterator.hasNext()) {
            Product currentProduct = iterator.next();

            if (currentProduct.getProductName().equals(name)) {
                removedProduct.add(currentProduct);
                iterator.remove();
            }
        }
        return removedProduct;
    }
}
