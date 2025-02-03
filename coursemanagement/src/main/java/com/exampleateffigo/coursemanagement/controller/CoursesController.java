package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping
    public List<Courses> getAllCourses()
    {
        return coursesService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Optional<Courses> getCourseById(@PathVariable long id)
    {
        return coursesService.getCourseById(id);
    }

    @PostMapping
    public Courses createCourse(@RequestBody Courses course) {
        return coursesService.createCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable long id) {
        coursesService.deleteCourse(id);
    }

}
