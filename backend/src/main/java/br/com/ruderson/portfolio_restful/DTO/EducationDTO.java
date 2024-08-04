package br.com.ruderson.portfolio_restful.DTO;

import br.com.ruderson.portfolio_restful.DTO.validations.ValidDateRange;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class EducationDTO {
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(message = "Nome precisa ter de 3 a 80 caracteres", min = 3, max = 80)
    private String courseName;

    @NotNull(message = "Campo requerido")
    @Positive(message = "Valor deve ser positivo")
    private Integer workload;

    @NotBlank(message = "Campo requerido")
    @Size(message = "Nome precisa ter de 3 a 80 caracteres", min = 3, max = 80)
    private String institution;

    @NotNull(message = "Campo requerido")
    private LocalDate startDate;

    private LocalDate endDate;
    private String certificateUrl;
}
