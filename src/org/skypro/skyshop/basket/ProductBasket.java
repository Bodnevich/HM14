package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductBasket {

    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct (Product product) {
        List<Product> listOfSameProducts = products.computeIfAbsent(product.getProductName(), k -> new LinkedList<>());
        listOfSameProducts.add(product);
        }

    public int totalCost () {
        int totalCost = 0;
        for (List<Product> sameNamedProducts : products.values()) {
            for (Product product : sameNamedProducts) {
                totalCost += product.getProductPrice();
            }
        }
            return totalCost;
    }
    void printBasket() {
        int specialCount = 0;
        int totalCostInPrintMethod = 0;

        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (List<Product> sameNamedProducts: products.values()) {
            for (Product product : sameNamedProducts) {
                System.out.println(product.toString());
                totalCostInPrintMethod += product.getProductPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " +specialCount);
    }
    public boolean productSearch(String productName) {
       return products.containsKey(productName);
    }

    void clearBasket() {
            products.clear();
        }

    List<Product> removeProductsByName (String name) {
        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : new LinkedList<>();
    }
}
