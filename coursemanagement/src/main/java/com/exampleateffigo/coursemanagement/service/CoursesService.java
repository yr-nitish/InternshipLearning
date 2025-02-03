package com.exampleateffigo.coursemanagement.service;

import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.repository.CoursesRepository;
import com.exampleateffigo.coursemanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private UsersRepository usersRepository;

    public List<Courses> getAllCourses()
    {
        return coursesRepository.findAll();
    }

    public Optional<Courses> getCourseById(long id)
    {
        return coursesRepository.findById(id);
    }

    public Courses createCourse(Courses course)
    {
        return coursesRepository.save(course);
    }

    public void deleteCourse(long id)
    {
        coursesRepository.deleteById(id);
    }
}
