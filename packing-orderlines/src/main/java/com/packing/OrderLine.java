package com.packing;

import java.util.UUID;

public class OrderLine {
    private final String id;
    private final int numberOfProducts;
    private final Product product;

    public OrderLine(final int numberOfProducts, final Product product) {
        this.id = UUID.randomUUID().toString();
        this.numberOfProducts = numberOfProducts;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public double volume() {
        return product.volume() * numberOfProducts;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                " numberOfProducts=" + numberOfProducts +
                ", product=" + product +
                '}';
    }
}
