package com.fawry;

import java.time.LocalDate;
import com.fawry.model.*;
import com.fawry.service.CheckoutService;

public class Main {
    public static void main(String[] args) {
        // Products
        Cheese cheese = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(5), 0.4);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 5, LocalDate.now().plusDays(2), 0.7);
        TV tv = new TV("TV", 5000, 3, 10.0);
        Mobile mobile = new Mobile("Mobile", 2000, 10);
        ScratchCard scratchCard = new ScratchCard("ScratchCard", 50, 100);

      
        Customer customer = new Customer("Abanoub", 10000);
       
        Cart cart = new Cart();
        try {
            cart.add(cheese, 2);
            cart.add(tv, 1);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 2);
        }
         catch (Exception e) {
            System.out.println( e.getMessage());
            return;
        }
       
        CheckoutService.checkout(customer, cart);
    }
} 