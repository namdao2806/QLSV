package com.example.demo.controller;

import com.example.demo.model.Image;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<Iterable<Student>> findAllByNameContaining(@RequestParam String name,@PageableDefault(size = 2) Pageable pageable) {
        return new ResponseEntity<>(studentService.findAllByNameContaining(pageable, name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),
                    new File("/Users/daonhuanh/Desktop/Codegym/Module1/demoAjax/image/" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Image image = new Image(fileName, fileName);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @GetMapping("/clazz")
    public ResponseEntity findByCategoryId(@RequestParam Long id) {
        return new ResponseEntity(studentService.findAllByClazzId(id), HttpStatus.OK);
    }
//nal
    @GetMapping("/score-between")
    public ResponseEntity findByCategoryId(@RequestParam Double from, Double to) {
        return new ResponseEntity(studentService.findAllScoreBetween(from, to), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> edit(@RequestBody Student student, @PathVariable Long id) {
        student.setId(id);
        studentService.save(student);
        return new ResponseEntity<>(studentService.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
