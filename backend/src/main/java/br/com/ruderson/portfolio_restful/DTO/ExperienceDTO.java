package br.com.ruderson.portfolio_restful.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExperienceDTO {
    private Long id;
    private String position;
    private String company;
    private String city;
    private String state;
    private String country;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
