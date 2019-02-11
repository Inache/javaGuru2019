package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import java.math.BigDecimal;

public interface ProductValidationRule {

    void validate(Product product);

    default void checkNotNull(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product must not be null");
        }
    }

    default void checkProductsNameLength(Product product) {
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ProductValidationException("Products name cant be less than 3, and cant exceed 32");
        }
    }

    default void checkPrice(Product product) {
        BigDecimal bigDecimalValue = product.getPrice();
        if (bigDecimalValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price must be > 0");
        }
    }

    default void checkDiscount(Product product) {
        BigDecimal bigDecimalValue = product.getDiscount();
        if (bigDecimalValue.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException();
        }
    }
}
