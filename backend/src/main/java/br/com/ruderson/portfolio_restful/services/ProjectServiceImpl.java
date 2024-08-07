package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.*;
import br.com.ruderson.portfolio_restful.entities.Category;
import br.com.ruderson.portfolio_restful.entities.Project;
import br.com.ruderson.portfolio_restful.entities.ProjectImage;
import br.com.ruderson.portfolio_restful.entities.Skill;
import br.com.ruderson.portfolio_restful.mappers.ProjectMapper;
import br.com.ruderson.portfolio_restful.projections.ProjectSummaryProjection;
import br.com.ruderson.portfolio_restful.repositories.CategoryRepository;
import br.com.ruderson.portfolio_restful.repositories.ProjectImageRepository;
import br.com.ruderson.portfolio_restful.repositories.ProjectRepository;
import br.com.ruderson.portfolio_restful.repositories.SkillRepository;
import br.com.ruderson.portfolio_restful.services.exceptions.DatabaseException;
import br.com.ruderson.portfolio_restful.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final SkillRepository skillRepository;
    private final CategoryRepository categoryRepository;
    private final ProjectImageRepository projectImageRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper
            , CategoryRepository categoryRepository, SkillRepository skillRepository, ProjectImageRepository projectImageRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.categoryRepository = categoryRepository;
        this.skillRepository = skillRepository;
        this.projectImageRepository = projectImageRepository;
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
        Project entity = new Project();
        entity.setName(dto.getName());
        entity.setShortDescription(dto.getShortDescription());
        entity.setLongDescription(dto.getLongDescription());
        entity.setGithubUrl(dto.getGithubUrl());
        entity.setLiveUrl(dto.getLiveUrl());

        entity = projectRepository.save(entity);

        Set<ProjectImage> images = new HashSet<>();

        for(ProjectImageDTO imageDTO : dto.getImages()) {
            ProjectImage projectImage = new ProjectImage();
            projectImage.setPath(imageDTO.getPath());
            projectImage.setImgCover(imageDTO.getImgCover());
            projectImage.setProject(entity);
            projectImageRepository.save(projectImage);
            images.add(projectImage);
        }

        entity.setProjectImages(images);

        List<Long> categoriesIds = dto.getCategories().stream().map(CategoryDTO::getId).toList();
        List<Long> skillsIds = dto.getTechnologies().stream().map(SkillResponse::getId).toList();

        Set<Category> categories = new HashSet<>(categoryRepository.findAllById(categoriesIds));
        Set<Skill> technologies = new HashSet<>(skillRepository.findAllById(skillsIds));

        entity.setCategories(categories);
        entity.setSkills(technologies);

        entity = projectRepository.save(entity);
        return projectMapper.toDto(entity);
    }

    @Override
    public ProjectDTO update(Long id, ProjectDTO dto) {
        try {
            Project entity = projectRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com o id " + id));

            entity.setName(dto.getName());
            entity.setShortDescription(dto.getShortDescription());
            entity.setLongDescription(dto.getLongDescription());
            entity.setGithubUrl(dto.getGithubUrl());
            entity.setLiveUrl(dto.getLiveUrl());

            // Atualizar as imagens
            Set<ProjectImage> existingImages = entity.getProjectImages();
            Set<ProjectImage> newImages = new HashSet<>();

            for(ProjectImageDTO imageDTO : dto.getImages()) {
                ProjectImage projectImage = existingImages.stream()
                        .filter(img -> img.getPath().equals(imageDTO.getPath()))
                        .findFirst()
                        .orElse(new ProjectImage());

                projectImage.setPath(imageDTO.getPath());
                projectImage.setImgCover(imageDTO.getImgCover());
                projectImage.setProject(entity);
                projectImageRepository.save(projectImage);
                newImages.add(projectImage);
            }

            entity.setProjectImages(newImages);

            // Atualizar categorias e tecnologias
            List<Long> categoriesIds = dto.getCategories().stream().map(CategoryDTO::getId).toList();
            List<Long> skillsIds = dto.getTechnologies().stream().map(SkillResponse::getId).toList();

            Set<Category> categories = new HashSet<>(categoryRepository.findAllById(categoriesIds));
            Set<Skill> technologies = new HashSet<>(skillRepository.findAllById(skillsIds));

            entity.setCategories(categories);
            entity.setSkills(technologies);

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
