package com.example.demo.service;

import com.example.demo.model.Product;

public interface IProductService extends IService<Product> {
    Iterable<Product> findAllByOrderByPrice();
    Iterable<Product> findAllByPriceBetween(int from, int to);
}
