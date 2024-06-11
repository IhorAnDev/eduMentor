package com.enterprise.edumentorapi.controllers;

import com.enterprise.edumentorapi.entity.Course;


import com.enterprise.edumentorapi.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

    @Value("${upload.path-image}")
    private String uploadPath;

    private final CourseService courseService;


    @PostMapping(value = "/upload/{courseId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(@PathVariable Long courseId,
                                              @RequestParam("file") MultipartFile file) throws IOException {
        Path uploadDir = Paths.get(uploadPath);
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        String originalFileName = file.getOriginalFilename();
        if (originalFileName != null) {
            originalFileName = originalFileName.replaceAll("\\s+", "_"); // Replace spaces with underscores
        }
        String fileName = UUID.randomUUID().toString() + "_" + originalFileName;
        Path filePath = uploadDir.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);

        Course course = courseService.getCourseById(courseId);
        String imageUrl = "/images/" + fileName;
        courseService.addImageToCourse(course, imageUrl);

        return ResponseEntity.ok(imageUrl);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) throws IOException {
        Path filePath = Paths.get(uploadPath, fileName);
        byte[] image = Files.readAllBytes(filePath);
        return ResponseEntity.ok().body(image);
    }
}
