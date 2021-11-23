package com.carlosfrmax.example.services;

import com.carlosfrmax.example.domain.Product;
import com.carlosfrmax.example.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductsServiceImp")
public class ProductsServiceImp implements ProductsService {

    ProductRepository productRepository;

    public ProductsServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
