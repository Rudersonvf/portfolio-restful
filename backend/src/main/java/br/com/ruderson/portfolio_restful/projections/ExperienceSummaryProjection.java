package br.com.ruderson.portfolio_restful.projections;

import java.time.LocalDate;

public interface ExperienceSummaryProjection {
    String getPosition();
    String getCompany();
    LocalDate getStartDate();
    LocalDate getEndDate();
}
