package com.packing;

import java.util.UUID;

public class Product extends ThreeDimensionObject {

    private String id;

    public Product(final double sizeX, final double sizeY, final double sizeZ) {
        super(sizeX, sizeY, sizeZ);
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Product{" +
                "sizeX=" + getSizeX() +
                ", sizeY=" + getSizeY() +
                ", sizeZ=" + getSizeZ() +
                '}';
    }
}
