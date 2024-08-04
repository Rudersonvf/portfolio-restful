package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.entities.Experience;
import br.com.ruderson.portfolio_restful.projections.ExperienceSummaryProjection;
import br.com.ruderson.portfolio_restful.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService{
    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    @Transactional
    public List<ExperienceSummaryProjection> findAll() {
        return experienceRepository.findAllProjectedBy();
    }
}
