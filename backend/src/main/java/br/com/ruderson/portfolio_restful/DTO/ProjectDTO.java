package br.com.ruderson.portfolio_restful.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Size(min = 20, max = 100, message = "Descrição deve ter entre 20 e 100 caracteres")
    private String shortDescription;
    @NotBlank(message = "Campo requerido")
    @Size(min = 20, max = 600, message = "Descrição deve ter entre 20 e 600 caracteres")
    private String longDescription;
    private String githubUrl;
    private String liveUrl;

    private List<ProjectImageDTO> images = new ArrayList<>();

    private List<CategoryDTO> categories = new ArrayList<>();

    private List<SkillResponse> technologies = new ArrayList<>();
}
