package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.projections.ProjectSummaryProjection;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryProjection> findAll();

}
