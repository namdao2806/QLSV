package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findAllByNameContaining(Pageable pageable, String name);

    Page<Student> findAllByScoreGreaterThan(Pageable pageable, Double score);

    Iterable<Class> findAllByClazzId(Long id);

    Iterable<Student> findAllByScoreBetween(Double from, Double to);

    @Query(value = "select * from Student order by id desc  limit 2", nativeQuery = true)
    Iterable<Product> findTop2Student();

}
