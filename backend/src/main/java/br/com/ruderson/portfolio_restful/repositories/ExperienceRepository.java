package br.com.ruderson.portfolio_restful.repositories;

import br.com.ruderson.portfolio_restful.entities.Experience;
import br.com.ruderson.portfolio_restful.projections.ExperienceSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    @Query("SELECT e.position, e.company, e.start_date, e.end_date FROM Experience e")
    List<ExperienceSummaryProjection> findAllProjectedBy();
}
