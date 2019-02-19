package com.packing;

import java.util.UUID;

public class Case extends ThreeDimensionObject {

    private final String id;

    public Case(final double sizeX, final double sizeY, final double sizeZ) {
        super(sizeX, sizeY, sizeZ);
        this.id = UUID.randomUUID().toString();
    }

    public PackResult canPack(final OrderLine orderLine) {
        return new PackResult(orderLine, this);
    }

    @Override
    public String toString() {
        return "Case{" +
                "sizeX=" + getSizeX() +
                ", sizeY=" + getSizeY() +
                ", sizeZ=" + getSizeZ() +
                '}';
    }

}
