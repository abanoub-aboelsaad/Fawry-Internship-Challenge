package com.fawry.service;

import java.util.*;
import com.fawry.model.*;
import com.fawry.interfaces.Shippable;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        double subtotal = 0;
        double shipping = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            int quantity = item.getQuantity();

            if (p.isExpired()) {
                System.out.println(p.getName() + " is expired!");
                return;
            }
            if (quantity > p.getQuantity()) {
                System.out.println(p.getName() + " is out of stock!");
                return;
            }

            subtotal = subtotal + p.getPrice() * quantity;
            if (p instanceof Shippable) {
                for (int i = 0; i < quantity; i++) toShip.add((Shippable) p);
                
                if (p instanceof TV) {
                    shipping = shipping + 50 * quantity;
                } else if (p instanceof Mobile) {
                    shipping = shipping + 50 * quantity;
                } else if (p instanceof Cheese || p instanceof Biscuits) {
                    shipping = shipping + 15 * quantity;
                } else {
                    shipping = shipping + 10 * quantity;
                }
            }
        }

        double total = subtotal + shipping;
        if (customer.getBalance() < total) {
            System.out.println("Insufficient balance");
            return;
        }

        ShippingService.ship(toShip);

        System.out.println("** Checkout receipt ** ");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getProduct().getPrice() * item.getQuantity());
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        System.out.println("----------------------");

        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shipping);
        System.out.printf("Amount %.0f\n", total);

        customer.reduceBalance(total);
        System.out.printf("Customer balance: %.0f\n", customer.getBalance());
    }
} 