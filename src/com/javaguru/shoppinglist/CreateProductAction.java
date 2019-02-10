package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        validateProductName(name);
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        System.out.println("Enter product price: ");
        String price = scanner.nextLine();
        validateProductPrice(price);
        System.out.println("Enter product discount: ");
        String discount = scanner.nextLine();
        validateProductDiscount(discount);
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(new BigDecimal(price));
        product.setDiscount(new BigDecimal(discount));
        product.setDescription(description);

        try {
            Long response = productService.create(product);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void validateProductName(String name) {
        if (name.length() < 3 || name.length() > 32) {
            throw new IllegalArgumentException();
        }
    }

    public void validateProductPrice(String price) {
        BigDecimal bigDecimalValue = new BigDecimal(price);
        if (bigDecimalValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateProductDiscount(String discount) {
        BigDecimal bigDecimalValue = new BigDecimal(discount);
        if (bigDecimalValue.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
