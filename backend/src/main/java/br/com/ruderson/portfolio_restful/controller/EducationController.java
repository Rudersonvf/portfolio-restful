package br.com.ruderson.portfolio_restful.controller;

import br.com.ruderson.portfolio_restful.DTO.EducationDTO;
import br.com.ruderson.portfolio_restful.projections.EducationSummaryProjection;
import br.com.ruderson.portfolio_restful.services.EducationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/educations")
public class EducationController {
    private final EducationServiceImpl educationService;

    public EducationController(EducationServiceImpl educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public ResponseEntity<List<EducationSummaryProjection>> findAll() {
        return ResponseEntity.ok(educationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationDTO> findById(@PathVariable Long id) {
        EducationDTO dto = educationService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<EducationDTO> create(@RequestBody EducationDTO dto) {
        EducationDTO createdEducation = educationService.insert(dto);
        return ResponseEntity.created(URI.create("/education/" + createdEducation.getId())).body(createdEducation);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<EducationDTO> update(@PathVariable Long id, @Valid @RequestBody EducationDTO dto) {
        dto = educationService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        educationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
