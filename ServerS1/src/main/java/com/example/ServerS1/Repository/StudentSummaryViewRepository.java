package com.example.ServerS1.Repository;

import com.example.ServerS1.Entity.StudentSummaryViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSummaryViewRepository extends JpaRepository<StudentSummaryViewEntity, Long> {

//    @Query("Select s from StudentSummaryViewEntity s where s.language = :language")
//    List<StudentSummaryViewEntity> findByLanguage(@Param("language") String language);

    @Query(value = "SELECT * FROM get_student_summary_by_language(:language)", nativeQuery = true)
    List<StudentSummaryViewEntity> findByLanguage(@Param("language") String language);
}
