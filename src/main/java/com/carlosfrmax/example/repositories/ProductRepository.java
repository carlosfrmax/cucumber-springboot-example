package com.carlosfrmax.example.repositories;

import com.carlosfrmax.example.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAllProducts();

    void save(Product product);

    void delete(Product product);
}
