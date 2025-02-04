package com.exampleateffigo.coursemanagement.service;

import com.exampleateffigo.coursemanagement.dto.CourseRequestDTO;
import com.exampleateffigo.coursemanagement.dto.CourseResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.mappers.CourseMapper;
import com.exampleateffigo.coursemanagement.repository.CoursesRepository;
import com.exampleateffigo.coursemanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CourseMapper courseMapper;

    public List<CourseResponseDTO> getAllCourses()
    {
        List<Courses> courses = coursesRepository.findAll();
        return courses.stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseResponseDTO getCourseById(long id)
    {
        Courses courses= coursesRepository.findById(id).orElseThrow(() ->new RuntimeException("Course not found"));
        return courseMapper.toDTO(courses);
    }

    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO)
    {
        Courses course = courseMapper.toEntity(courseRequestDTO);
        course = coursesRepository.save(course);
        return courseMapper.toDTO(course);
    }

    public void deleteCourse(long id)
    {
        coursesRepository.deleteById(id);
    }
}
