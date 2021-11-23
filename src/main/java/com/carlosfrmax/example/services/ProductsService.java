package com.carlosfrmax.example.services;

import com.carlosfrmax.example.domain.Product;

import java.util.List;

public interface ProductsService {

    List<Product> getAllProducts();

    void delete(Product product);

    void save(Product product);
}
