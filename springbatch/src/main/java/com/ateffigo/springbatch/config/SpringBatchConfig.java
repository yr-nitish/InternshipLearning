package com.ateffigo.springbatch.config;

import com.ateffigo.springbatch.entity.Student;
import com.ateffigo.springbatch.listener.StudentSkipListener;
import com.ateffigo.springbatch.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
//@EnableBatchProcessing
public class SpringBatchConfig {
    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final StudentSkipListener studentSkipListener;

    @Autowired
    public SpringBatchConfig(StudentRepository studentRepository, StudentSkipListener studentSkipListener) {
        this.studentRepository = studentRepository;
        this.studentSkipListener = studentSkipListener;
    }

    @Bean
    public JsonItemReader<Student> reader() {
        JacksonJsonObjectReader<Student> jsonObjectReader = new JacksonJsonObjectReader<>(Student.class);
        JsonItemReader<Student> jsonItemReader = new JsonItemReader<>();
        jsonItemReader.setJsonObjectReader(jsonObjectReader);
        jsonItemReader.setResource(new ClassPathResource("dummyjson.json"));
        jsonItemReader.setName("reader");
        jsonItemReader.setStrict(false);
        return jsonItemReader;
    }

    @Bean
    public StudentProcessor processor(){
        return new StudentProcessor();
    }

    @Bean
    public RepositoryItemWriter<Student> writer(){
        RepositoryItemWriter<Student> writer=new RepositoryItemWriter<>();
        writer.setRepository(studentRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("jsonStep", jobRepository)
                .<Student, Student>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(500)
                .listener(studentSkipListener)
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("jsonJob", jobRepository)
                .start(step)
                .build();
    }
}