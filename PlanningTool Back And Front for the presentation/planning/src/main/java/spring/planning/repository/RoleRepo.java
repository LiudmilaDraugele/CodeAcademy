package spring.planning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.planning.entity.Role;
import spring.planning.entity.Roles;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(Roles name);

	Role getReferenceByName(String name);

}
