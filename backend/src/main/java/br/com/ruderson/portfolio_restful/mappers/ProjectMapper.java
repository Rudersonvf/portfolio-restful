package br.com.ruderson.portfolio_restful.mappers;

import br.com.ruderson.portfolio_restful.DTO.ProjectDTO;
import br.com.ruderson.portfolio_restful.DTO.SkillResponse;
import br.com.ruderson.portfolio_restful.entities.Project;
import br.com.ruderson.portfolio_restful.entities.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "skills", target = "technologies", qualifiedByName = "skillToSkillResponse")
    @Mapping(source = "projectImages", target = "images")
    ProjectDTO toDto(Project entity);

    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "technologies", target = "skills")
    @Mapping(source = "images", target = "projectImages")
    Project toEntity(ProjectDTO dto);

    @Named("skillToSkillResponse")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    SkillResponse skillToSkillResponse(Skill skill);
}