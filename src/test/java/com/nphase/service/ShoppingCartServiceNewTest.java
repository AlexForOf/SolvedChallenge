package com.nphase.service;

import com.nphase.entity.ProductNew;
import com.nphase.entity.ShoppingCartNew;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingCartServiceNewTest {
    private final ShoppingCartServiceNew service = new ShoppingCartServiceNew();

    @Test
    public void calculatesPrice()  {
        ShoppingCartNew cart = new ShoppingCartNew(Arrays.asList(
                new ProductNew("Tea", BigDecimal.valueOf(5.3), 2, "drinks", 3, 0.1),
                new ProductNew("Coffee", BigDecimal.valueOf(3.5), 2, "drinks",3, 0.1),
                new ProductNew("Cheese", BigDecimal.valueOf(8), 2, "food",3, 0.1)
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(31.84));
    }

}