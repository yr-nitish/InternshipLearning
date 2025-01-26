package com.effigo.springrest.services;

import com.effigo.springrest.entities.Course;
import dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;
    List<Course> list;

    public CourseServiceImpl()
    {
//        list=new ArrayList<>();
//        list.add(new Course(145, "Java Core concepts", "this contains core basic java"));
//        list.add(new Course(123,"dsa for beginners", "this contains all the dsa concepts"));


    }


    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

//    public Course getCourse(long courseId)
//    {
//        Course c=null;
//        for (Course course:list)
//        {
//            if (course.getId()==courseId)
//            {
//                c=course;
//                break;
//            }
//        }
//        return courseDao.getOne(courseId);
//    }

    public Course getCourse(long courseId) {
        return courseDao.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));
    }


    public Course addCourse(Course course)
    {
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    public Course updateCourse(Course course)
    {
//        list.forEach(e-> {
//            if (e.getId()==course.getId()) {
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
//        return  course;

        courseDao.save(course);
        return course;
    }

    public void deleteCourse(long parseLong)
    {
//        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
        Course entity = courseDao.getOne(parseLong);
        courseDao.delete(entity);
    }
}
