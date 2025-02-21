package com.ateffigo.springbatch.config;

import com.ateffigo.springbatch.entity.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student, Student> {
    public Student process(Student student) throws Exception{
        return student;
    }
}
