package br.com.ruderson.portfolio_restful.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Campo requerido")
    private String name;

    @NotBlank(message = "Campo requerido")
    private String level;

    @NotBlank(message = "Campo requerido")
    @Size(min = 20, max = 600, message = "Descrição deve ter entre 15 e 400 caracteres")
    private String description;

    @NotBlank(message = "Campo requerido")
    private String documentationUrl;

    @NotBlank(message = "Campo requerido")
    private String iconPath;
}
