package com.example.demo.controller;

import com.example.demo.service.StorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class FileUploadController {

    @Autowired
    StorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity<String>  uploadFile(@RequestParam("file")MultipartFile file) {
        storageService.store(file);
        System.out.println(file.getName());
        return ResponseEntity.ok("Uploaded");
    }

    @GetMapping("/getFile/{fileName:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws IOException {
        System.out.println("file name is:- "+fileName);
        Resource file = storageService.loadAsResource(fileName);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
