package br.com.ruderson.portfolio_restful.controller;

import br.com.ruderson.portfolio_restful.DTO.SkillDTO;
import br.com.ruderson.portfolio_restful.projections.SkillSummaryProjection;
import br.com.ruderson.portfolio_restful.services.SkillServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillServiceImpl skillService;

    public SkillController(SkillServiceImpl skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<List<SkillSummaryProjection>> findAll() {
        List<SkillSummaryProjection> result = skillService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> findById(@PathVariable Long id) {
        SkillDTO result = skillService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<SkillDTO> insert(@RequestBody SkillDTO dto) {
        SkillDTO result = skillService.save(dto);
        return ResponseEntity.created(URI.create("/skills/" + result.getId())).body(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<SkillDTO> update(@PathVariable Long id, @RequestBody SkillDTO dto) {
        SkillDTO result = skillService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        skillService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
