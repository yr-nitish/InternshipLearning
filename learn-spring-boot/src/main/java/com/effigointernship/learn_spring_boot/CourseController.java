package com.effigointernship.learn_spring_boot;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//http://localhost:8080/courses

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses()
    {
        return Arrays.asList(
                new Course(1, "Learn Spring", "xyz"),
                new Course(2, "Learn Springboot", "abc")
        );
    }


}
