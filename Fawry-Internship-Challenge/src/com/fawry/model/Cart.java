package com.fawry.model;

import java.util.*;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) throws IllegalArgumentException {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("no enough stock for " + product.getName() +
                    " | Requested: " + quantity + ", Available: " + product.getQuantity());
        }

        items.add(new CartItem(product, quantity));
    }
    public List<CartItem> getItems() { 
        return items; 
    }

    public boolean isEmpty() { 
        return items.isEmpty();
     }
} 