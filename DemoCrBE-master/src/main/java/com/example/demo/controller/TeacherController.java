package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping()
    public ResponseEntity findAll(){
        return new ResponseEntity<>(teacherRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity add(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherRepository.save(teacher),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Teacher teacher,@PathVariable Long id) {
        teacher.setId(id);
        teacherRepository.save(teacher);
        return new ResponseEntity<>(teacherRepository.findById(id).get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        teacherRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
