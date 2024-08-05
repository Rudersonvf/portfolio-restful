package br.com.ruderson.portfolio_restful.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SkillDTO {
    private Long id;
    private String name;
    private String level;
    private String description;
    private String documentationUrl;
    private String iconPath;
}
