package br.com.ruderson.portfolio_restful.DTO;

import br.com.ruderson.portfolio_restful.entities.Category;
import br.com.ruderson.portfolio_restful.entities.ProjectImage;
import br.com.ruderson.portfolio_restful.entities.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String name;
    private String shortDescription;
    private String longDescription;
    private String githubUrl;
    private String liveUrl;

    private List<ProjectImage> images = new ArrayList<>();

    private List<Category> categories = new ArrayList<>();

    private List<Skill> technologies = new ArrayList<>();
}
