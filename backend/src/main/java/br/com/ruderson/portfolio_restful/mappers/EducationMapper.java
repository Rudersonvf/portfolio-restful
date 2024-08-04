package br.com.ruderson.portfolio_restful.mappers;

import br.com.ruderson.portfolio_restful.DTO.EducationDTO;
import br.com.ruderson.portfolio_restful.entities.Education;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EducationMapper {
    EducationMapper INSTANCE = Mappers.getMapper(EducationMapper.class);

    EducationDTO toDto(Education entity);

    Education toEntity(EducationDTO dto);
}
