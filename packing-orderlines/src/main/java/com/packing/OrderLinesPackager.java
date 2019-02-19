package com.packing;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderLinesPackager {

    private final List<OrderLine> orderLines;
    private final List<Case> cases;

    public OrderLinesPackager(final List<OrderLine> orderLines, final List<Case> cases) {
        this.orderLines = orderLines;
        this.cases = cases;
    }

    public Map<Case, OrderLine> pack() {
        final Map<Case, PackResult> packResultMap = orderLines.stream()
                .map(this::findCases).flatMap(Collection::stream)
                .collect(Collectors.toMap(PackResult::getCaseBox, p -> p, PackResult::getSmaller));
        return packResultMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, p -> p.getValue().getOrderLine()));
    }

    private List<PackResult> findCases(final OrderLine order) {
        return cases.stream().map(box -> box.canPack(order)).filter(PackResult::isCanBePacked)
                .sorted().collect(Collectors.toList());
    }
}
