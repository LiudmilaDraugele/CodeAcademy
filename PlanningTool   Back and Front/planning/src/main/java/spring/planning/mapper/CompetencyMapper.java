package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.CompetencyDto;
import spring.planning.dto.EmployeeDto;
import spring.planning.dto.TaskDto;
import spring.planning.entity.Competency;
import spring.planning.service.EmployeeService;
import spring.planning.service.TaskService;


@Service
public class CompetencyMapper {
	
	@Autowired 
	EmployeeService empService;
	@Autowired 
	EmployeeMapper empMapper;
	@Autowired 
	TaskService taskService;
	@Autowired 
	TaskMapper taskMapper;
	
	public CompetencyDto toDto(Competency entity) {
		if (entity == null) {
			return null;
		}
		CompetencyDto dto = new CompetencyDto();
		dto.setId(entity.getId());
		dto.setLevel(entity.getLevel());
		dto.setEmployeeId(entity.getEmployee().getId());
		dto.setTaskId(entity.getTask().getId());
	
		return dto;
	}
	
	public Competency fromDto(CompetencyDto dto) {
		if (dto == null) {
			return null;
		}
		Competency entity = new Competency();
		entity.setId(dto.getId());
		entity.setLevel(dto.getLevel());
		EmployeeDto empDto = empService.findById(dto.getEmployeeId());
		entity.setEmployee(empMapper.fromDto(empDto));
		TaskDto taskDto = taskService.findById(dto.getTaskId());
		entity.setTask(taskMapper.fromDto(taskDto));
		
		
	
		return entity;
	}
	
	public List<CompetencyDto> toDtoList(List<Competency> entities){
		List<CompetencyDto> dtos = new ArrayList<>();
		
		for (Competency entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

}
