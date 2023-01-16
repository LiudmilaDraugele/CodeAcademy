package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import spring.planning.dto.EmployeeDto;
import spring.planning.dto.TeamDto;
import spring.planning.entity.Employee;
import spring.planning.entity.Role;
import spring.planning.entity.Team;
import spring.planning.mapper.EmployeeMapper;
import spring.planning.mapper.TeamMapper;
import spring.planning.repository.EmployeeRepo;
import spring.planning.repository.RoleRepo;
import spring.planning.repository.TeamRepo;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo repository;
	@Autowired
	TeamRepo teamRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	EmployeeMapper mapper;
	@Autowired
	PasswordEncoder encoder;
	
	public EmployeeDto findById(Long id) {
		
		Employee employee = repository.findById(id).orElse(null);
		EmployeeDto empDto = mapper.toDto(employee);
		
		return empDto;
	}
	
	public List<EmployeeDto> findAllEmployees(){
		
		List<Employee> employees = (ArrayList<Employee>) repository.findAll();
		
		return mapper.toDtoList(employees);
		
	}
	
	public EmployeeDto createEmployee(EmployeeDto empDto) {
		
		Employee employee = mapper.fromDto(empDto);
		repository.save(employee);
		
		return mapper.toDto(employee);
		
	}
	
	public EmployeeDto updateEmployee(EmployeeDto empDto, Long id) {
		Employee employee = repository.findById(id).orElse(null);
		////employee = mapper.fromDto(empDto);
		/// va cia pakoreguoti kaip update team pavyzdi
		repository.save(employee);
		return mapper.toDto(employee);
	}
	
	public EmployeeDto updateEmployeeWithTeamRole(EmployeeDto empDto, Long id, Long teamId,Long roleId) {
		Employee employee = repository.findById(id).orElse(null);
		Team team = teamRepo.findById(teamId).orElse(null);
		Role role = roleRepo.findById(roleId).orElse(null);
		
		employee.setTeam(team);
		if (employee.getRoles() == null) {
		employee.getRoles().add(role);
		}
		else {
			employee.getRoles().clear();
			employee.getRoles().add(role);
		}
		
		repository.save(employee);
		return mapper.toDto(employee);
	}
	
	public EmployeeDto updateEmployeeWithHours(EmployeeDto empDto, Long id, Integer min) {
		Employee employee = repository.findById(id).orElse(null);
		employee.setMinutes(min);
		repository.save(employee);
		return mapper.toDto(employee);
	}
	
	public EmployeeDto updateEmployeePassword(EmployeeDto empDto, Long id) {
		Employee employee = repository.findById(id).orElse(null);
		
		employee.setPassword(encoder.encode(empDto.getPassword()));
		repository.save(employee);
		return mapper.toDto(employee);
	}
	
	
	public void deleteEmployee(Long id) {
		
		repository.deleteById(id);
	}

	public List<EmployeeDto> findEmployesByTeamId(Long id) {
		List<Employee> employees = repository.findAllByTeam_Id(id);
		return mapper.toDtoList(employees);
	}
	

}
