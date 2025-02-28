package com.example.ServerS1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "student_summary")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Immutable
public class StudentSummary {

    @Id
    private long id;
    private String name;
    private String language;
}
