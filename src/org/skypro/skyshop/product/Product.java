package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected String productName;

    public Product(String productName) {
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
}
