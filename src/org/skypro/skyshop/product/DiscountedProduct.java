package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getProductPrice() {
        return (int)(basePrice * (100 - discount)/100);
    }

    @Override
    public String toString() {
        return getProductName() + ": Цена со скидкой " + getProductPrice() + ", скидка " + discount + "%)";
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}