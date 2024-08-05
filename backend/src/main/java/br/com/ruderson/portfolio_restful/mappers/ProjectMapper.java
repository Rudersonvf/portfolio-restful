package br.com.ruderson.portfolio_restful.mappers;

import br.com.ruderson.portfolio_restful.DTO.ProjectDTO;
import br.com.ruderson.portfolio_restful.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDTO toDto(Project entity);

    Project toEntity(ProjectDTO dto);
}
