package com.exampleateffigo.one_to_many_application1.services;

import com.exampleateffigo.one_to_many_application1.entity.Book;
import com.exampleateffigo.one_to_many_application1.entity.Student;
import com.exampleateffigo.one_to_many_application1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id)
    {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student)
    {
        if(student.getBookList()!=null)
        {
            for (Book book :student.getBookList())
            {
                book.setStudent(student);
            }
        }
        return studentRepository.save(student);
    }
}
