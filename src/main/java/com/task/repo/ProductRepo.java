package com.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.product.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer> {

}
