package com.exampleateffigo.one_to_one_p2.service;

import com.exampleateffigo.one_to_one_p2.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> getAllProjects();

    Optional<Project> getProjectById(int id);

    Project addProject(Project project);
}
