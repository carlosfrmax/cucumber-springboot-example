package com.carlosfrmax.example.services;

import com.carlosfrmax.example.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProductServiceMock")
public class ProductServiceMock implements ProductsService {

    List<Product> products;

    public ProductServiceMock(List<Product> products) {
        this.products = new ArrayList<>();
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}
