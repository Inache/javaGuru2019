package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        BigDecimal bigDecimalValue = product.getDiscount();
        if (bigDecimalValue.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException();
        }
    }
}
