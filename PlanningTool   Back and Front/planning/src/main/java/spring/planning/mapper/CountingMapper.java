package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.CountingDto;
import spring.planning.entity.Counting;
import spring.planning.entity.Task;
import spring.planning.entity.Team;
import spring.planning.repository.TaskRepo;


@Service
public class CountingMapper {
	
	@Autowired
	TaskRepo taskRepo;
	
	public CountingDto toDto(Counting entity) {
		if (entity == null) {
			return null;
		}
		CountingDto dto = new CountingDto();
		dto.setId(entity.getId());
		dto.setDate(entity.getDate());
		dto.setCount(entity.getCount());
		dto.setTaskId(entity.getTask().getId());
		dto.setTaskName(entity.getTask().getName());
		dto.setComment(entity.getComment());
		
		return dto;
	}
	
	public Counting fromDto(CountingDto dto) {
		if (dto == null) {
			return null;
		}
		Counting entity = new Counting();
		entity.setId(dto.getId());
		entity.setDate(dto.getDate());
		entity.setCount(dto.getCount());
		Task taskReference = taskRepo.getReferenceById(dto.getTaskId());
		entity.setTask(taskReference);
		entity.setComment(dto.getComment());
	
		return entity;
	}
	
	public List<CountingDto> toDtoList(List<Counting> entities){
		List<CountingDto> dtos = new ArrayList<>();
		
		for (Counting entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

}
