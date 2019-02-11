package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import java.util.*;

public class ProductsInMemoryRepository {

    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product insert(Product product) {
        product.setId(productIdSequence);
        products.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product getProductById(Long id) {
        return products.get(id);
    }

    public Collection<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

}
