package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import spring.planning.dto.EmployeeDto;
import spring.planning.dto.PlanDto;
import spring.planning.dto.TeamDto;
import spring.planning.entity.Additional;
import spring.planning.entity.Competency;
import spring.planning.entity.Employee;
import spring.planning.entity.Plan;
import spring.planning.entity.Role;
import spring.planning.entity.Team;
import spring.planning.mapper.EmployeeMapper;
import spring.planning.mapper.TeamMapper;
import spring.planning.repository.AdditionalRepo;
import spring.planning.repository.CompetencyRepo;
import spring.planning.repository.EmployeeRepo;
import spring.planning.repository.PlanRepo;
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
	@Autowired
	CompetencyRepo competencyRepo;
	@Autowired
	PlanRepo planRepo;
	@Autowired
	AdditionalRepo additionalRepo;
	
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
		
//		List<Plan> planListByEmployee = planRepo.findAllByEmployee_Id(id);
//		Plan plan = new Plan();
//		Long planId = 0L;
//		
//		for(int i=0; i<planListByEmployee.size(); i++) {
//			planId =  planListByEmployee.get(i).getId();
//			plan = planRepo.findById(planId).orElse(null);
//			plan.setEmployee(null);
//			planRepo.save(plan);	
//		}
//		
//		List<Competency> competencyListByEmployee = competencyRepo.findAllByEmployee_Id(id);
//		Competency competency = new Competency();
//		Long competencyId = 0L;
//		
//		for(int i=0; i<competencyListByEmployee.size(); i++) {
//			competencyId =  competencyListByEmployee.get(i).getId();
//			competency = competencyRepo.findById(competencyId).orElse(null);
//			competency.setEmployee(null);
//			competencyRepo.save(competency);	
//		}
//		
//		List<Additional> additionalListByEmployee = additionalRepo.findAllByEmployee_Id(id);
//		Additional additional = new Additional();
//		Long additionalId = 0L;
//		
//		for(int i=0; i<additionalListByEmployee.size(); i++) {
//			additionalId =  additionalListByEmployee.get(i).getId();
//			additional = additionalRepo.findById(additionalId).orElse(null);
//			additional.setEmployee(null);
//			additionalRepo.save(additional);	
//		}

		repository.deleteById(id);
	}

	public List<EmployeeDto> findEmployesByTeamId(Long id) {
		List<Employee> employees = repository.findAllByTeam_Id(id);
		return mapper.toDtoList(employees);
	}
	

}
