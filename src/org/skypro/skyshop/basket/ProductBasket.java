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
        return products.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getProductPrice)
                .sum();
    }
    void printBasket() {

        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        products.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
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
