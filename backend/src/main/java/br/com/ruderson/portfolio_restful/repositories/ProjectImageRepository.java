package br.com.ruderson.portfolio_restful.repositories;

import br.com.ruderson.portfolio_restful.entities.ProjectImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectImageRepository extends JpaRepository<ProjectImage, Long> {
}
