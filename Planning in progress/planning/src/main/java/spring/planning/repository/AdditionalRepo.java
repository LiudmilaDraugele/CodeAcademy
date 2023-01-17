package spring.planning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.planning.entity.Additional;
import spring.planning.entity.Competency;

@Repository
public interface AdditionalRepo extends JpaRepository<Additional, Long> {
	
	public List<Additional> findAllByDate(String date);
	
	public List<Additional> findAllByEmployee_Id(Long id);

}
