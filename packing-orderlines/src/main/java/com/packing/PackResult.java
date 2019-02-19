package com.packing;

public class PackResult implements Comparable<PackResult> {
    private boolean canBePacked;
    private OrderLine orderLine;
    private Case caseBox;
    private double remainingSpace;

    public PackResult(final OrderLine orderLine, final Case caseBox) {
        final Product product = orderLine.getProduct();
        this.orderLine = orderLine;
        this.caseBox = caseBox;

        this.canBePacked = caseBox.volume() >= orderLine.volume()
                && ((caseBox.getSizeX() >= product.getSizeX()
                && caseBox.getSizeY() >= product.getSizeY()
                && caseBox.getSizeZ() >= product.getSizeZ())
                || (caseBox.getSizeY() >= product.getSizeX()
                && caseBox.getSizeZ() >= product.getSizeY()
                && caseBox.getSizeX() >= product.getSizeZ())
                || (caseBox.getSizeZ() >= product.getSizeX()
                && caseBox.getSizeX() >= product.getSizeY()
                && caseBox.getSizeY() >= product.getSizeZ()));
        if (canBePacked) {
            this.remainingSpace = caseBox.volume() - orderLine.volume();
        }
    }

    public boolean isCanBePacked() {
        return canBePacked;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public Case getCaseBox() {
        return caseBox;
    }

    public PackResult getSmaller(final PackResult other) {
        return compareTo(other) <= 0 ? this : other;
    }

    @Override
    public int compareTo(final PackResult other) {
        final double diff = remainingSpace - other.remainingSpace;
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        }
        return 0;
    }
}

