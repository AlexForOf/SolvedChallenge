package com.nphase.entity;

import java.math.BigDecimal;

public class ProductNew {
    private final String name;
    private final BigDecimal pricePerUnit;
    private final int quantity;
//    Task 3(category)
    private final String category;
//    Task 4
    private final int discountAmount;
    private final double discountPercentage;

    public ProductNew(String name, BigDecimal pricePerUnit, int quantity, String category, int discountAmount, double discountPercentage) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.category = category;
        this.discountAmount = discountAmount;
        this.discountPercentage = discountPercentage;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

/*
    Task 4
    I've implemented the task 4 in the way of initialization of categoryAmount and categoryDiscount for each product on the stage of initialization of each entity
    in order to get more precision in developing discount policy as for the real-life example
*/

    public double getCategoryDiscount(){
        return discountPercentage;
    }

    public int getCategoryAmount()
    {
        return discountAmount;
    }

/*
    Task 2
    For this task I've chosen the approach of calculating updated price per unit for each product in our shopping cart and then returning it forward into shopping cart overall
    price calculation in order to include all the discounts we could have into total sum

*/
    public BigDecimal getDiscountedPricePerUnit(){
        if (this.quantity > discountAmount){
            BigDecimal discountNumber = pricePerUnit.multiply(BigDecimal.valueOf(1 - discountPercentage));
            return pricePerUnit.subtract(discountNumber);
        }else{
            return pricePerUnit;
        }
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

}
