package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.ProjectDTO;
import br.com.ruderson.portfolio_restful.entities.Project;
import br.com.ruderson.portfolio_restful.mappers.ProjectMapper;
import br.com.ruderson.portfolio_restful.projections.ProjectSummaryProjection;
import br.com.ruderson.portfolio_restful.repositories.ProjectRepository;
import br.com.ruderson.portfolio_restful.services.exceptions.DatabaseException;
import br.com.ruderson.portfolio_restful.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectSummaryProjection> findAll() {
        return projectRepository.findProjectsWithCoverImage();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectSummaryProjection> findAllByCategory(Long categoryId) {
        return projectRepository.findProjectsByCategoryId(categoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectDTO findById(Long id) {
        Project result = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com o id " + id));
        return projectMapper.toDto(result);
    }

    @Override
    @Transactional
    public ProjectDTO save(ProjectDTO dto) {
        Project entity = projectMapper.toEntity(dto);
        entity = projectRepository.save(entity);
        return projectMapper.toDto(entity);

        // ajustar para vincular e salvar categorias, lista de imagens e tecnologias.
    }

    @Override
    public ProjectDTO update(Long id, ProjectDTO dto) {
        try {
            Project entity = projectRepository.getReferenceById(id);

            entity.setName(dto.getName());
            entity.setShortDescription(dto.getShortDescription());
            entity.setLongDescription(dto.getLongDescription());
            entity.setGithubUrl(dto.getGithubUrl());
            entity.setLiveUrl(dto.getLiveUrl());

            entity = projectRepository.save(entity);
            return projectMapper.toDto(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Projeto não encontrado com o id " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Projeto não encontrado com o id " + id);
        }

        try {
            projectRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha na integridade referencial");
        }
    }
}
