package br.com.ruderson.portfolio_restful.repositories;

import br.com.ruderson.portfolio_restful.entities.Skill;
import br.com.ruderson.portfolio_restful.projections.SkillSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query("SELECT s.name AS name, s.iconPath AS iconPath FROM Skill s")
    List<SkillSummaryProjection> findAllProjectedBy();
}
