package com.exampleateffigo.one_to_one_p2.controller;

import com.exampleateffigo.one_to_one_p2.entity.Project;
import com.exampleateffigo.one_to_one_p2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects()
    {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable int id)
    {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public Project addProject(@RequestBody Project project)
    {
        Project savedProject = projectService.addProject(project);
        return ResponseEntity.ok(savedProject).getBody();
    }
}
