package br.com.ruderson.portfolio_restful.repositories;

import br.com.ruderson.portfolio_restful.entities.Project;
import br.com.ruderson.portfolio_restful.projections.ProjectSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p.name AS name, p.shortDescription AS shortDescription, i.path AS path " +
            "FROM Project p " +
            "JOIN p.projectImages i " +
            "WHERE i.imgCover = true")
    List<ProjectSummaryProjection> findProjectsWithCoverImage();

    @Query("SELECT p.name AS name, p.shortDescription AS shortDescription, i.path AS path " +
            "FROM Project p " +
            "JOIN p.projectImages i " +
            "JOIN p.categories c " +
            "WHERE i.imgCover = true AND c.id = :categoryId" )
    List<ProjectSummaryProjection> findProjectsByCategoryId(@Param("categoryId") Long categoryId);
}
