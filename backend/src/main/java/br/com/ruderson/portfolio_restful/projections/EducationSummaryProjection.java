package br.com.ruderson.portfolio_restful.projections;

import java.time.LocalDate;

public interface EducationSummaryProjection {
    String getCourseName();
    String getInstitution();
    LocalDate getStartDate();
    LocalDate getEndDate();
}
