package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    protected String productName;

    public Product(String productName) {
        if (productName == null || productName.trim().isBlank()) {
            throw new IllegalArgumentException("Продукт не может быть пустым, заполните название!");
        }
        this.productName = productName;
    }

    public String getProductName () {
        return productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();

        @Override
        public String getSearchTerm() {
        return productName;
        }

        @Override
        public String getContentType() {
        return "Product";
        }

        @Override
        public String getObjectName() {
        return productName;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productName='" + productName + '\'' +
                    '}';
        }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}
