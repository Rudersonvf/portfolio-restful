package br.com.ruderson.portfolio_restful.controller;

import br.com.ruderson.portfolio_restful.DTO.ExperienceDTO;
import br.com.ruderson.portfolio_restful.projections.ExperienceSummaryProjection;
import br.com.ruderson.portfolio_restful.services.ExperienceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    private final ExperienceServiceImpl experienceService;

    public ExperienceController(ExperienceServiceImpl experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public ResponseEntity<List<ExperienceSummaryProjection>> getAllExperiences() {
        return ResponseEntity.ok(experienceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceDTO> findById(@PathVariable Long id) {
        ExperienceDTO experienceDTO = experienceService.findById(id);
        return ResponseEntity.ok(experienceDTO);
    }

    @PostMapping
    public ResponseEntity<ExperienceDTO> createExperience(@RequestBody ExperienceDTO dto) {
        ExperienceDTO createdExperience = experienceService.insert(dto);
        return ResponseEntity.created(URI.create("/experiences/" + createdExperience.getId())).body(createdExperience);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceDTO> updateExperience(@PathVariable Long id, @RequestBody ExperienceDTO dto) {
        dto = experienceService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        experienceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
