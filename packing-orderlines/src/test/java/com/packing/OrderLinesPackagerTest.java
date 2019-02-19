package com.packing;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderLinesPackagerTest {

    @Test
    public void packSameSize() {
        final List<Product> products = IntStream.iterate(1, d -> ++d).limit(10)
                .mapToObj(i -> new Product(i, i, i)).collect(Collectors.toList());
        products.forEach(System.out::println);
        final List<Case> cases = IntStream.iterate(1, d -> ++d).limit(10)
                .mapToObj(i -> new Case(i, i, i)).collect(Collectors.toList());
        final List<OrderLine> orderLines = IntStream.iterate(1, d -> ++d).limit(10)
                .mapToObj(i -> new OrderLine(1, products.get(i - 1))).collect(Collectors.toList());
        orderLines.forEach(System.out::println);
        final Map<Case, OrderLine> pack = new OrderLinesPackager(orderLines, cases).pack();
        pack.forEach((c, o) -> System.out.println(c + " " + o));
        Assert.assertEquals(orderLines.size(), pack.size());
    }

    @Test
    public void pack2() {
        final List<Product> products = IntStream.iterate(1, d -> ++d).limit(10)
                .mapToObj(i -> new Product(i, i, i)).collect(Collectors.toList());
        final List<Case> cases = IntStream.iterate(1, d -> ++d).limit(10).map(d -> d * 2)
                .mapToObj(i -> new Case(i, i, i)).collect(Collectors.toList());
        final List<OrderLine> orderLines = IntStream.iterate(1, d -> ++d).limit(10)
                .mapToObj(i -> new OrderLine(2, products.get(i - 1))).collect(Collectors.toList());
        final Map<Case, OrderLine> pack = new OrderLinesPackager(orderLines, cases).pack();
        pack.forEach((c, o) -> System.out.println(c + " " + o));
        Assert.assertEquals(orderLines.size(), pack.size());
    }

    @Test
    public void pack3() {
        final List<Product> products = IntStream.iterate(1, d -> ++d).limit(10)
                .mapToObj(i -> new Product(i, i, i)).collect(Collectors.toList());
        final List<Case> cases = IntStream.iterate(1, d -> ++d).limit(10).map(d -> d * 2)
                .mapToObj(i -> new Case(i, i, i)).collect(Collectors.toList());
        final List<OrderLine> orderLines = IntStream.iterate(1, d -> ++d).limit(10)
                .mapToObj(i -> new OrderLine(3, products.get(i - 1))).collect(Collectors.toList());
        final Map<Case, OrderLine> pack = new OrderLinesPackager(orderLines, cases).pack();
        pack.forEach((c, o) -> System.out.println(c + " " + o));
        Assert.assertNotEquals(orderLines.size(), pack.size());
    }

}
