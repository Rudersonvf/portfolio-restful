package br.com.ruderson.portfolio_restful.controller;

import br.com.ruderson.portfolio_restful.projections.ProjectSummaryProjection;
import br.com.ruderson.portfolio_restful.services.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectSummaryProjection>> findAll(){
        return ResponseEntity.ok(projectService.findAll());
    }

}
