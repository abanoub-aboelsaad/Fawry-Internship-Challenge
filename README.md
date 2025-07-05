# Fawry-Internship-Challenge


## System Overview

This project implements a simple e-commerce system
## Core Features

### Product Management

- **Product Definition**: All products have name, price, and quantity attributes
- **Product Types**:
  - **Expirable Products**: Cheese and Biscuits with expiration dates
  - **Non-Expirable Products**: TV and Mobile with no expiration
  - **Digital Products**: Scratch cards with no physical attributes

### Shipping System

- **Shippable Products**: Cheese and TV require shipping
- **Non-Shippable Products**: Mobile scratch cards do not require shipping
- **Weight Requirement**: Every shippable item must provide its weight
- **Shipping Interface**: Products implement an interface with `getName()` and `getWeight()` methods

### Shopping Cart Functionality

- **Add to Cart**: Customers can add products with specific quantities
- **Quantity Validation**: Cannot add more than available product quantity
- **Cart Management**: Maintains list of items with their quantities

### Checkout Process

The checkout system provides  order processing with detailed console output.


#### Error Handling

The system validates and reports errors for:

- **Empty Cart**: Cannot checkout with no items
- **Insufficient Balance**: Customer doesn't have enough funds
- **Out of Stock**: Product quantity is insufficient
- **Expired Products**: Products past their expiration date

#### Shipping Integration

- **Item Collection**: Gathers all items requiring shipping
- **ShippingService**: Sends shippable items to shipping service
- **Interface Compliance**: All shippable items implement the required interface

