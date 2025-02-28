package com.example.ServerS1.Repository;

import com.example.ServerS1.Entity.StudentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentSummaryRepository extends JpaRepository<StudentSummary, Long> {

    @Query("Select s from StudentSummary s where s.language = :language")
    List<StudentSummary> findByLanguage(@Param("language") String language);


}
