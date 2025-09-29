package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getProductPrice() {
        return (int)(basePrice * (100 - discount)/100);
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice() + " (" + discount + "%)";
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}