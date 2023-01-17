package spring.planning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.planning.entity.Competency;

@Repository
public interface CompetencyRepo extends JpaRepository<Competency, Long> {
	
	public List<Competency> findAllByLevel(Integer level);

}
