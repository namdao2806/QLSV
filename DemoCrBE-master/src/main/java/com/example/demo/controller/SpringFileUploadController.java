package com.example.demo.controller;

import java.io.File;

import com.example.demo.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class SpringFileUploadController {
    @PostMapping("/upload")
    public ResponseEntity<Post> handleFileUpload(@RequestParam("file") MultipartFile file, Post post) {
        String fileName = file.getOriginalFilename();
        post.setImage(fileName);
        try {
            file.transferTo(new File("/Users/daonhuanh/Desktop/DemoAjaxCR/demo/image/" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(post);
    }

}