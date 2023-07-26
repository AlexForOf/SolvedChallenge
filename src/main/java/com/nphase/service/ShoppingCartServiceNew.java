package com.nphase.service;

import com.nphase.entity.ProductNew;
import com.nphase.entity.ShoppingCartNew;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;

public class ShoppingCartServiceNew {
    public BigDecimal calculateTotalPrice(ShoppingCartNew shoppingCart) {
        return shoppingCart.calculateTotalPrice();
    }
}
