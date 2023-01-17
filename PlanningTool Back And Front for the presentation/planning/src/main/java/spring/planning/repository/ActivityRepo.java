package spring.planning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.planning.entity.Activities;
import spring.planning.entity.Activity;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Long> {
	
	Optional<Activity> findByName(Activities name);

	Activity getReferenceByName(String name);

}
