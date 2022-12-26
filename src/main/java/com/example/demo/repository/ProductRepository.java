package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByOrderByPrice();

    Iterable<Product> findAllByPriceBetween(int from, int to);

    @Query(value = "select * from product order by id desc  limit 4", nativeQuery = true)
    Iterable<Product> findTop4New();
}
