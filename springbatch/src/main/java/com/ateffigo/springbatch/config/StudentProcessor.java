package com.ateffigo.springbatch.config;

import com.ateffigo.springbatch.entity.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student, Student> {
    @Override
    public Student process(Student student) throws Exception {
        try {
            if (student.getVersion() < 0) {
                throw new IllegalArgumentException("Version cannot be negative");
            }
            return student;
        } catch (Exception e) {
            System.err.println("Skipping record in processor due to: " + e.getMessage());
            throw e; // Ensure the step's skip policy catches this
        }
    }
}
