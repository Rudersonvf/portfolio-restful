package br.com.ruderson.portfolio_restful.controller;

import br.com.ruderson.portfolio_restful.projections.ExperienceSummaryProjection;
import br.com.ruderson.portfolio_restful.services.ExperienceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
