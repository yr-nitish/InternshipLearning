package com.exampleateffigo.one_to_one_p2.repository;

import com.exampleateffigo.one_to_one_p2.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
