package com.fawry.service;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import com.fawry.interfaces.Shippable;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");

     
        Map<String, Integer> itemCounts = new LinkedHashMap<>();
        Map<String, Double> itemWeights = new LinkedHashMap<>();
        
        for (Shippable item : items) {
            String name = item.getName();
            itemCounts.put(name, itemCounts.getOrDefault(name, 0) + 1);
            itemWeights.put(name, item.getWeight());
        }
        
        double totalWeight = 0;
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            double weight = itemWeights.get(name);
            System.out.printf("%dx %s %.0fg\n", count, name, weight * 1000);
            totalWeight = totalWeight + weight * count;
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
