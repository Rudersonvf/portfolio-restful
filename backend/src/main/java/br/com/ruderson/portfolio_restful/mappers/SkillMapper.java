package br.com.ruderson.portfolio_restful.mappers;

import br.com.ruderson.portfolio_restful.DTO.SkillDTO;
import br.com.ruderson.portfolio_restful.entities.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    SkillDTO toDto(Skill entity);

    Skill toEntity(SkillDTO dto);

}
