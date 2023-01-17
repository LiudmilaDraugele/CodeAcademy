package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.PlanDto;
import spring.planning.entity.Employee;
import spring.planning.entity.Plan;
import spring.planning.entity.Task;
import spring.planning.repository.EmployeeRepo;
import spring.planning.repository.TaskRepo;

@Service
public class PlanMapper {
	
	@Autowired 
	EmployeeRepo employeeRepo;
	@Autowired 
	TaskRepo taskRepo;
	
	public PlanDto toDto(Plan entity) {
		if (entity == null) {
			return null;
		}
		PlanDto dto = new PlanDto();
		dto.setId(entity.getId());
		dto.setDate(entity.getDate());
		dto.setEmployeeId(entity.getEmployee().getId());
		dto.setTaskId(entity.getTask().getId());
		dto.setCount(entity.getCount());
		dto.setMarked(entity.isMarked());
		dto.setDone(entity.isDone());
		
		return dto;
	}
	
	public Plan fromDto(PlanDto dto) {
		if (dto == null) {
			return null;
		}
		Plan entity = new Plan();
		entity.setId(dto.getId());
		entity.setDate(dto.getDate());
		
		Employee employeeReference = employeeRepo.getReferenceById(dto.getEmployeeId());
		entity.setEmployee(employeeReference);
		Task taskReference = taskRepo.getReferenceById(dto.getTaskId());
		entity.setTask(taskReference);
		entity.setCount(dto.getCount());
		entity.setMarked(dto.isMarked());
		entity.setDone(dto.isDone());
		return entity;
	}
	
	public List<PlanDto> toDtoList(List<Plan> entities){
		List<PlanDto> dtos = new ArrayList<>();
		
		for (Plan entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

}
