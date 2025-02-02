package com.exampleateffigo.one_to_one_p2.service;

import com.exampleateffigo.one_to_one_p2.entity.Project;
import com.exampleateffigo.one_to_one_p2.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects()
    {
        return projectRepository.findAll();
    }

    public Optional <Project> getProjectById(int id)
    {
        return projectRepository.findById(id);
    }

    public Project addProject(Project project)
    {
       project.getStudent().setProject(project);
        return projectRepository.save(project);
    }

    public Project updateProject(int id, Project updatedProject) {
        return projectRepository.findById(id).map(project -> {
            project.setProjectTitle(updatedProject.getProjectTitle());
            project.setProjectDomain(updatedProject.getProjectDomain());
            project.setStudent(updatedProject.getStudent());
            return projectRepository.save(project);
        }).orElse(null);
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }

}
