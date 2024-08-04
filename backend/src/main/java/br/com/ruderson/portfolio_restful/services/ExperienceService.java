package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.projections.ExperienceSummaryProjection;

import java.util.List;

public interface ExperienceService {
    List<ExperienceSummaryProjection> findAll();


}
