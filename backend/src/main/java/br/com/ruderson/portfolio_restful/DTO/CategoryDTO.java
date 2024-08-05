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
public class CategoryDTO {
    private Long id;
    @NotBlank(message = "Campo requerido")
    @Size(message = "Nome precisa ter de 3 a 80 caracteres", min = 3, max = 80)
    private String name;
}
