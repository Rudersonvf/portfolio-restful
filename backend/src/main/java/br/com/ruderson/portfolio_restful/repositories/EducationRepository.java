package br.com.ruderson.portfolio_restful.repositories;

import br.com.ruderson.portfolio_restful.entities.Education;
import br.com.ruderson.portfolio_restful.projections.EducationSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

    @Query("SELECT e.courseName AS courseName, e.institution AS institution, e.endDate AS endDate, e.startDate AS startDate " +
            "FROM Education e")
    List<EducationSummaryProjection> findAllProjectedBy();
}
