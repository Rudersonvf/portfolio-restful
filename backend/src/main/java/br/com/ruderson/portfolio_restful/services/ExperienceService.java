package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.ExperienceDTO;
import br.com.ruderson.portfolio_restful.projections.ExperienceSummaryProjection;

import java.util.List;

public interface ExperienceService {
    List<ExperienceSummaryProjection> findAll();

    ExperienceDTO findById(Long id);

    ExperienceDTO insert(ExperienceDTO experienceDTO);

    ExperienceDTO update(Long id, ExperienceDTO experienceDTO);

    void deleteById(Long id);
}
