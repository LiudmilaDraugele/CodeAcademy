package spring.planning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.planning.entity.SlaType;
import spring.planning.entity.Type;


@Repository
	public interface SlaTypeRepo extends JpaRepository<SlaType, Long> {
		
		Optional<SlaType> findByType(Type type);

		SlaType getReferenceByType(String type);

}
