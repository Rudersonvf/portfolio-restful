package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.EducationDTO;
import br.com.ruderson.portfolio_restful.entities.Education;
import br.com.ruderson.portfolio_restful.mappers.EducationMapper;
import br.com.ruderson.portfolio_restful.projections.EducationSummaryProjection;
import br.com.ruderson.portfolio_restful.repositories.EducationRepository;
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
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository, EducationMapper educationMapper) {
        this.educationRepository = educationRepository;
        this.educationMapper = educationMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EducationSummaryProjection> findAll() {
        return educationRepository.findAllProjectedBy();
    }

    @Override
    @Transactional(readOnly = true)
    public EducationDTO findById(Long id) {
        Education entity = educationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o id " + id));
        return educationMapper.toDto(entity);
    }

    @Override
    @Transactional
    public EducationDTO insert(EducationDTO dto) {
        Education entity = educationMapper.toEntity(dto);
        entity = educationRepository.save(entity);
        return educationMapper.toDto(entity);
    }

    @Override
    @Transactional
    public EducationDTO update(Long id, EducationDTO dto) {
        try {
            Education entity = educationRepository.getReferenceById(id);

            entity.setCourseName(dto.getCourseName());
            entity.setWorkload(dto.getWorkload());
            entity.setInstitution(dto.getInstitution());
            entity.setStartDate(dto.getStartDate());
            entity.setEndDate(dto.getEndDate());
            entity.setCertificateUrl(dto.getCertificateUrl());
            entity = educationRepository.save(entity);

            return educationMapper.toDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Curso não encontrado com o id " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if (!educationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Curso não encontrado com o id " + id);
        }

        try {
            educationRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha na integridade referencial");
        }
    }
}
