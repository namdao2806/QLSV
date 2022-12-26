package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findAllByNameContaining(Pageable pageable, String name) {
        return studentRepository.findAllByNameContaining(pageable, name);
    }


    @Override
    public Page<Student> findAllByScoreGreaterThan8(Pageable pageable, Double score) {
        return studentRepository.findAllByScoreGreaterThan(pageable, score);
    }

    @Override
    public Iterable<Class> findAllByClazzId(Long id) {
        return studentRepository.findAllByClazzId(id);
    }

    @Override
    public Iterable<Student> findAllScoreBetween(Double from, Double to) {
        return studentRepository.findAllByScoreBetween(from, to);
    }

}