package br.com.ruderson.portfolio_restful.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectImageDTO {
    private Long id;
    private String path;
    private Boolean imgCover;
}
