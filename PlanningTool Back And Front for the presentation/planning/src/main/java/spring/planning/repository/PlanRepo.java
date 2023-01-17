package spring.planning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.planning.entity.Plan;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Long>{
	
	public List<Plan> findAllByDate(String date);

}
