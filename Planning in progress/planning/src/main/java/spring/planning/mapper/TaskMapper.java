package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.TaskDto;
import spring.planning.entity.Role;
import spring.planning.entity.SlaType;
import spring.planning.entity.Task;
import spring.planning.entity.Team;
import spring.planning.repository.SlaTypeRepo;
import spring.planning.repository.TeamRepo;

@Service
public class TaskMapper {
	
	@Autowired
	TeamRepo teamRepo;
	@Autowired
	SlaTypeRepo slaRepo;
	
	public TaskDto toDto(Task entity) {
		if (entity == null) {
			return null;
		}
		TaskDto dto = new TaskDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setMinutes(entity.getMinutes());
		dto.setType(entity.getType());
		dto.setSla(entity.getSla());
		dto.setTeamId(entity.getTeam().getId());
		dto.setOngoing(entity.getOngoing());
		
		return dto;
	}
	
	public Task fromDto(TaskDto dto) {
		if (dto == null) {
			return null;
		}
		Task entity = new Task();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setMinutes(dto.getMinutes());
		entity.setType(dto.getType());
		entity.setSla(dto.getSla());
		if (dto.getTeamId()!=null) {
			Team teamReference = teamRepo.getReferenceById(dto.getTeamId());
			entity.setTeam(teamReference);
			}
		entity.setOngoing(dto.getOngoing());
		
		return entity;
	}
	
	public List<TaskDto> toDtoList(List<Task> entities){
		List<TaskDto> dtos = new ArrayList<>();
		
		for (Task entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

}
