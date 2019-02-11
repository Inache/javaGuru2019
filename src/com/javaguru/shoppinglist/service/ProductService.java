package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductsInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import java.util.Collection;

public class ProductService {

    private ProductsInMemoryRepository repository = new ProductsInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.insert(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return repository.getProductById(id);
    }

    public Collection getAllProducts() {
        return repository.getAllProducts();
    }
}
