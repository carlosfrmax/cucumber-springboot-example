package com.carlosfrmax.example.repositories;

import com.carlosfrmax.example.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {
}
