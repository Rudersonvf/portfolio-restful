package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.projections.ProjectSummaryProjection;
import br.com.ruderson.portfolio_restful.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectSummaryProjection> findAll() {
        return projectRepository.findAllProjectedBy();
    }
}
