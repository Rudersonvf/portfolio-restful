package br.com.ruderson.portfolio_restful.mappers;

import br.com.ruderson.portfolio_restful.DTO.ExperienceDTO;
import br.com.ruderson.portfolio_restful.entities.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface ExperienceMapper {
    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);

    ExperienceDTO toDto(Experience entity);

    Experience toEntity(ExperienceDTO dto);
}
