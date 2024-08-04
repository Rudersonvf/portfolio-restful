package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.ExperienceDTO;
import br.com.ruderson.portfolio_restful.entities.Experience;
import br.com.ruderson.portfolio_restful.mappers.ExperienceMapper;
import br.com.ruderson.portfolio_restful.projections.ExperienceSummaryProjection;
import br.com.ruderson.portfolio_restful.repositories.ExperienceRepository;
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
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository, ExperienceMapper experienceMapper) {
        this.experienceRepository = experienceRepository;
        this.experienceMapper = experienceMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExperienceSummaryProjection> findAll() {
        return experienceRepository.findAllProjectedBy();
    }

    @Override
    @Transactional(readOnly = true)
    public ExperienceDTO findById(Long id) {
        Experience entity = experienceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Experiência não encontrada com o id " + id));
        return experienceMapper.toDto(entity);
    }

    @Override
    @Transactional
    public ExperienceDTO insert(ExperienceDTO dto) {
        Experience entity = experienceMapper.toEntity(dto);
        return experienceMapper.toDto(experienceRepository.save(entity));
    }

    @Override
    @Transactional
    public ExperienceDTO update(Long id, ExperienceDTO dto) {
        try {
            Experience entity = experienceRepository.getReferenceById(id);

            entity.setPosition(dto.getPosition());
            entity.setCompany(dto.getCompany());
            entity.setCity(dto.getCity());
            entity.setState(dto.getState());
            entity.setCountry(dto.getCountry());
            entity.setDescription(dto.getDescription());
            entity.setStartDate(dto.getStartDate());
            entity.setEndDate(dto.getEndDate());
            entity = experienceRepository.save(entity);

            return experienceMapper.toDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Experiência não encontrada com o id " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if (!experienceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Experiência não encontrada com o id " + id);
        }

        try {
            experienceRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
