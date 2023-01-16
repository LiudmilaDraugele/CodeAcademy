package spring.planning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.planning.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public Optional<Employee> findByEmail(String email);
	public Optional<Employee> findByShortname(String shortname);
	public List<Employee> findAllByTeam_Id(Long id);
}
