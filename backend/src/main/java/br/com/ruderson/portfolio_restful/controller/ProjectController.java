package br.com.ruderson.portfolio_restful.controller;

import br.com.ruderson.portfolio_restful.DTO.ProjectDTO;
import br.com.ruderson.portfolio_restful.projections.ProjectSummaryProjection;
import br.com.ruderson.portfolio_restful.services.ProjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectSummaryProjection>> findAll() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> findById(@PathVariable Long id) {
        ProjectDTO result = projectService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ProjectDTO> insert(@RequestBody @Valid ProjectDTO dto) {
        ProjectDTO result = projectService.save(dto);
        return ResponseEntity.created(URI.create("/projects/" + result.getId())).body(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@PathVariable Long id, @RequestBody @Valid ProjectDTO dto) {
        dto = projectService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
