package com.ateffigo.springbatch.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name="failed_student_batch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailedStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    private String id;

    private String failureReason;
}
