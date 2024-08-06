package br.com.ruderson.portfolio_restful.mappers;

import br.com.ruderson.portfolio_restful.DTO.ProjectDTO;
import br.com.ruderson.portfolio_restful.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "skills", target = "technologies")
    @Mapping(source = "projectImages", target = "images")
    ProjectDTO toDto(Project entity);

    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "technologies", target = "skills")
    @Mapping(source = "images", target = "projectImages")
    Project toEntity(ProjectDTO dto);
}
