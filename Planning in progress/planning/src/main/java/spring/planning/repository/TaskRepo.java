package spring.planning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.planning.entity.Employee;
import spring.planning.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>{

	public Optional<Task> findByName(String name);
		public List<Task> findAllByTeam_Id(Long id);
		public List<Task> findAllByType(String type);
		public List<Task> findAllBySla(Integer sla);
		public List<Task> findAllByTypeAndSla(String type, Integer sla);
}
