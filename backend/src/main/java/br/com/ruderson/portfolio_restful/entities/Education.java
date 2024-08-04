package br.com.ruderson.portfolio_restful.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "tb_education")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private Integer workload;
    private String institution;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    private String certificateUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(id, education.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
