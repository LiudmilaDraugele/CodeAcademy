package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.EmployeeDto;
import spring.planning.entity.Employee;
import spring.planning.entity.Role;
import spring.planning.entity.Task;
import spring.planning.entity.Team;
import spring.planning.repository.RoleRepo;
import spring.planning.repository.TeamRepo;



@Service
public class EmployeeMapper {
	
	@Autowired
	TeamRepo teamRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	RoleMapper roleMapper;
	
	public EmployeeDto toDto(Employee entity) {
		if (entity == null) {
			return null;
		}
		EmployeeDto dto = new EmployeeDto();
		dto.setId(entity.getId());
		dto.setShortname(entity.getShortname());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		if (entity.getTeam()!=null) {
		dto.setTeamId(entity.getTeam().getId());
		}
		dto.setMinutes(entity.getMinutes());
		
		dto.setRole(roleMapper.toDto(entity.getRoles().get(0)));
		
		dto.setActive(entity.isActive());
		
		return dto;
	}
	
	public Employee fromDto(EmployeeDto dto) {
		if (dto == null) {
			return null;
		}
		Employee entity = new Employee();
		entity.setId(dto.getId());
		entity.setShortname(dto.getShortname());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		if (dto.getTeamId()!=null) {
		Team teamReference = teamRepo.getReferenceById(dto.getTeamId());
		entity.setTeam(teamReference);
		}
		entity.setMinutes(dto.getMinutes());
		if (dto.getRole()!=null) {
			Role roleReference = roleRepo.getReferenceById(dto.getRole().getId());
			entity.getRoles().add(roleReference);
			}
		
		entity.setActive(dto.isActive());
	
		return entity;
	}
	
	public List<EmployeeDto> toDtoList(List<Employee> entities){
		List<EmployeeDto> dtos = new ArrayList<>();
		
		for (Employee entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}


}
