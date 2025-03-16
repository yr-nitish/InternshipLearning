package com.example.ServerS1.Service;

import com.example.ServerS1.Entity.Student;
import com.example.ServerS1.Repository.StudentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Data
@Service
@EnableCaching
public class StudentService {

    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;
    private final CacheManager cacheManager;

    @Autowired
    public StudentService(StudentRepository studentRepository, ObjectMapper objectMapper, CacheManager cacheManager) {
        this.studentRepository = studentRepository;
        this.objectMapper = objectMapper;
        this.cacheManager = cacheManager;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Cacheable(value = "cached_data", key = "#id")
    public List<Student> getStudentById(String id) {
        return studentRepository.findByStudentId(id);
    }

    @CacheEvict(value = "cached_data", allEntries = true)
    public void clearCache() {
        log.info("Clearing users cache");
    }

    public boolean isUserInCache(String id) {
        Cache cache = cacheManager.getCache("cached_data");
        if (cache == null) {
            return false;
        }
        return cache.get(id) != null;
    }

    public Map<String, Object> getCachedData() {
        Cache cache = cacheManager.getCache("cached_data");
        if (cache == null) {
            return Map.of("message", "Cache is empty or not found");
        }

        if (cache instanceof ConcurrentMapCache) {
            ConcurrentMapCache concurrentCache = (ConcurrentMapCache) cache;
            Map<Object, Object> nativeCache = concurrentCache.getNativeCache();

            return nativeCache.entrySet().stream()
                    .collect(Collectors.toMap(
                            entry -> entry.getKey().toString(),
                            Map.Entry::getValue
                    ));
        }

        return Map.of("message", "Cache type not supported");
    }

    public String uploadJsonFile() {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            File file = new File("src/main/resources/data.json");

            List<Student> students = objectMapper.readValue(file, new TypeReference<List<Student>>() {});

            studentRepository.saveAll(students);

            stopWatch.stop();
            long elapsedTime = stopWatch.getTotalTimeMillis(); // Get time in milliseconds

            return "Data loaded successfully in " + elapsedTime + " ms!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error loading data: " + e.getMessage();
        }
    }

    @Scheduled(fixedRate = 5000)
    public void sayHii() {
//        System.out.println("Hii!!!");
    }

    // Run every day at 11:55 AM
    @Scheduled(cron = "0 55 11 * * ?")
    public void greet() {
        System.out.println("Have a great day, Nitish!!");
    }
}
