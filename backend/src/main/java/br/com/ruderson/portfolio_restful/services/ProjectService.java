package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.ProjectDTO;
import br.com.ruderson.portfolio_restful.projections.ProjectSummaryProjection;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryProjection> findAll();

    List<ProjectSummaryProjection> findAllByCategory(Long categoryId);

    ProjectDTO findById(Long id);

    ProjectDTO save(ProjectDTO dto);

    ProjectDTO update(Long id, ProjectDTO dto);

    void deleteById(Long id);
}
