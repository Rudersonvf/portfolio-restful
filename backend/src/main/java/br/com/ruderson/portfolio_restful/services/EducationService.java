package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.EducationDTO;
import br.com.ruderson.portfolio_restful.projections.EducationSummaryProjection;

import java.util.List;

public interface EducationService {
    List<EducationSummaryProjection> findAll();

    EducationDTO findById(Long id);

    EducationDTO insert(EducationDTO dto);

    EducationDTO update(Long id, EducationDTO dto);

    void deleteById(Long id);
}
