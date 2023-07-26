package com.nphase.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartNew {
    private final List<ProductNew> products;

    public ShoppingCartNew(List<ProductNew> products) {
        this.products = products;
    }

    public List<ProductNew> getProducts() {
        return products;
    }

/*
    Task 3:
    In order to complete this task I've modified the source code and introduced calculation of total price in Shopping cart as I need to check whether
    we have 3 or more products of the same category in this shopping cart and the most convenient way for this is to check it in main entities pool
    After the calculation of total price we return it to ShoppingCartService and the process of calculation of the whole cart is finished
    P.S To notice, in this example not to create one more method just to leave task 3 in its basic view You can see the usage of task 4 variables in this method, which could be
    easily split, but I've decided that it's unnecessary as each task in my interpretation is an update of the previous one

*/
    public BigDecimal calculateTotalPrice() {
        Map<String, Integer> categoryQuantities = new HashMap<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (ProductNew product : products) {
            String category = product.getCategory();
            int quantity = product.getQuantity();
            categoryQuantities.put(category, categoryQuantities.getOrDefault(category, 0) + quantity);
        }

        for (ProductNew product : products){
            String category = product.getCategory();

            BigDecimal productPrice = product.getDiscountedPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity()));

            if (categoryQuantities.get(category) >= product.getCategoryAmount()){
                BigDecimal discountedPrice = productPrice.multiply(BigDecimal.valueOf(1.0 - product.getCategoryDiscount()));
                totalPrice = totalPrice.add(discountedPrice);
                System.out.println(totalPrice);
            }else {
                totalPrice = totalPrice.add(productPrice);
            }
        }
        return totalPrice;
    }
}
