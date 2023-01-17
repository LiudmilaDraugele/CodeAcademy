package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.TeamDto;
import spring.planning.entity.Team;
import spring.planning.service.EmployeeService;
import spring.planning.service.TaskService;

@Service
public class TeamMapper {
	
	@Autowired 
	EmployeeService empService;
	@Autowired 
	TaskService taskService;
	
	public TeamDto toDto(Team entity) {
		if (entity == null) {
			return null;
		}
		TeamDto dto = new TeamDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		
		dto.setEmployees(empService.findEmployesByTeamId(entity.getId()));
		dto.setTasks(taskService.findTasksByTeamId(entity.getId()));
		return dto;
	}
	
	public Team fromDto(TeamDto dto) {
		if (dto == null) {
			return null;
		}
		Team entity = new Team();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		
	
		return entity;
	}
	
	public List<TeamDto> toDtoList(List<Team> entities){
		List<TeamDto> dtos = new ArrayList<>();
		
		for (Team entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

}
