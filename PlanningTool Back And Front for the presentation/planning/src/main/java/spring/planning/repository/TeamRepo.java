package spring.planning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.planning.entity.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team,Long> {
	
	//public Optional<Team> findByEmployee_Id(Long id);

}
