package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.dto.CourseRequestDTO;
import com.exampleateffigo.coursemanagement.dto.CourseResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses()
    {
        return ResponseEntity.ok(coursesService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable long id)
    {
        CourseResponseDTO courseResponseDTO = coursesService.getCourseById(id);
        return ResponseEntity.ok(courseResponseDTO);
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.ok(coursesService.createCourse(courseRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id) {
        coursesService.deleteCourse(id);
        return ResponseEntity.ok("User  deleted successfully.");
    }
}
