package com.ateffigo.springbatch.listener;

import com.ateffigo.springbatch.entity.FailedStudent;
import com.ateffigo.springbatch.entity.Student;
import com.ateffigo.springbatch.repository.FailedStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.annotation.OnSkipInProcess;
import org.springframework.batch.core.annotation.OnSkipInRead;
import org.springframework.batch.core.annotation.OnSkipInWrite;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentSkipListener {

    private final FailedStudentRepository failedStudentRepository;

    @OnSkipInRead
    public void onSkipInRead(Throwable t) {
        System.out.println("Skipped record during reading due to: " + t.getMessage());

        FailedStudent failedStudent = new FailedStudent(
                null,
                null,
                "Read Error: " + t.getMessage()
        );
        failedStudentRepository.save(failedStudent);
    }

    @OnSkipInProcess
    public void onSkipInProcess(Student student, Throwable t) {
        System.err.println("Skipped record during processing: " + student.getId() + " due to: " + t.getMessage());

        FailedStudent failedStudent = new FailedStudent(
                student.getId1(),
                student.getId(),
                "Processing Error: " + t.getMessage()
        );
        failedStudentRepository.save(failedStudent);
    }

    @OnSkipInWrite
    public void onSkipInWrite(Student student, Throwable t) {
        System.err.println("Skipped record during writing: " + student.getId() + " due to: " + t.getMessage());

        FailedStudent failedStudent = new FailedStudent(
                student.getId1(),
                student.getId(),
                "Write Error: " + t.getMessage()
        );
        failedStudentRepository.save(failedStudent);
    }
}
