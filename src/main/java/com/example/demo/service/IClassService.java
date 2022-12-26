package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IClassService <Clazz>{
    Iterable<Clazz> findAll();
    Optional<Clazz> findById(Long id);

}