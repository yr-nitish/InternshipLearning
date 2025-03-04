package com.example.ServerS1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "student_summary_view")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSummaryViewEntity {

    @Id
    private long id1;
    private String id;
    private String name;
    private String language;
    private double version;
}
