package com.packing;

public class ThreeDimensionObject {
    private final double sizeX;
    private final double sizeY;
    private final double sizeZ;

    public ThreeDimensionObject(final double sizeX, final double sizeY, final double sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    public double getSizeX() {
        return sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }

    public double getSizeZ() {
        return sizeZ;
    }

    public double volume() {
        return sizeX * sizeY * sizeZ;
    }

    @Override
    public String toString() {
        return "ThreeDimensionObject{" +
                "sizeX=" + sizeX +
                ", sizeY=" + sizeY +
                ", sizeZ=" + sizeZ +
                '}';
    }
}
