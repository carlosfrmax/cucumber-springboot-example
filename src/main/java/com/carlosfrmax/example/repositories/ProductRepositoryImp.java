package com.carlosfrmax.example.repositories;

import com.carlosfrmax.example.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository{
    ProductCrudRepository productCrudRepository;

    public ProductRepositoryImp(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return (List<Product>) productCrudRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productCrudRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productCrudRepository.delete(product);
    }
}
