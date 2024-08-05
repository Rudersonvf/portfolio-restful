package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.SkillDTO;
import br.com.ruderson.portfolio_restful.projections.SkillSummaryProjection;

import java.util.List;

public interface SkillService {
    List<SkillSummaryProjection> findAll();

    SkillDTO findById(Long id);

    SkillDTO save(SkillDTO dto);

    SkillDTO update(Long id, SkillDTO dto);

    void deleteById(Long id);
}
