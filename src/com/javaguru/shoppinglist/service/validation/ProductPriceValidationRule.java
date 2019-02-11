package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        BigDecimal bigDecimalValue = product.getPrice();
        if (bigDecimalValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price must be > 0");
        }
    }
}
