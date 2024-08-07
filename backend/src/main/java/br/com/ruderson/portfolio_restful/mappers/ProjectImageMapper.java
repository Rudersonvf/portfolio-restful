package br.com.ruderson.portfolio_restful.mappers;

import br.com.ruderson.portfolio_restful.DTO.ProjectImageDTO;
import br.com.ruderson.portfolio_restful.entities.ProjectImage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectImageMapper {
    ProjectImageMapper INSTANCE = Mappers.getMapper(ProjectImageMapper.class);

    ProjectImageDTO toDto(ProjectImage entity);

    ProjectImage toEntity(ProjectImageDTO dto);
}
