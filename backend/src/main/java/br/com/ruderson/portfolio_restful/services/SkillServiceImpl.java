package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.SkillDTO;
import br.com.ruderson.portfolio_restful.entities.Skill;
import br.com.ruderson.portfolio_restful.mappers.SkillMapper;
import br.com.ruderson.portfolio_restful.projections.SkillSummaryProjection;
import br.com.ruderson.portfolio_restful.repositories.SkillRepository;
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
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SkillSummaryProjection> findAll() {
        return skillRepository.findAllProjectedBy();
    }

    @Override
    @Transactional(readOnly = true)
    public SkillDTO findById(Long id) {
        Skill entity = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tecnologia não encontrada com o id " + id));
        return skillMapper.toDto(entity);
    }

    @Override
    @Transactional
    public SkillDTO save(SkillDTO dto) {
        Skill entity = skillMapper.toEntity(dto);
        entity = skillRepository.save(entity);
        return skillMapper.toDto(entity);
    }

    @Override
    @Transactional
    public SkillDTO update(Long id, SkillDTO dto) {
        try {
            Skill entity = skillRepository.getReferenceById(id);

            entity.setName(dto.getName());
            entity.setLevel(dto.getLevel());
            entity.setDescription(dto.getDescription());
            entity.setDocumentationUrl(dto.getDocumentationUrl());
            entity.setIconPath(dto.getIconPath());
            entity = skillRepository.save(entity);

            return skillMapper.toDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Tecnologia não encontrada com o id " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if (!skillRepository.existsById(id)) {
            throw new ResourceNotFoundException("Technologia não encontrada com o id " + id);
        }

        try {
            skillRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
