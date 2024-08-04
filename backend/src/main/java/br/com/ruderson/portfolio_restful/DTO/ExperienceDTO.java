package br.com.ruderson.portfolio_restful.DTO;

import br.com.ruderson.portfolio_restful.DTO.validations.ValidDateRange;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@ValidDateRange
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExperienceDTO {
    private Long id;

    @NotBlank(message = "Campo requerido")
    private String position;

    @NotBlank(message = "Campo requerido")
    private String company;

    @NotBlank(message = "Campo requerido")
    private String city;

    @NotBlank(message = "Campo requerido")
    private String state;

    @NotBlank(message = "Campo requerido")
    private String country;

    @NotBlank(message = "Campo requerido")
    @Size(min = 15, max = 400, message = "Descrição deve ter entre 15 e 400 caracteres")
    private String description;

    @NotNull(message = "Campo requerido")
    private LocalDate startDate;

    private LocalDate endDate;
}
