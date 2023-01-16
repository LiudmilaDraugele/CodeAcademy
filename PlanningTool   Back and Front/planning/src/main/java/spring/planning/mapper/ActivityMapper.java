package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import spring.planning.dto.ActivityDto;
import spring.planning.entity.Activity;


@Service
public class ActivityMapper {

	
	public ActivityDto toDto(Activity entity) {
		if (entity == null) {
			return null;
		}
		ActivityDto dto = new ActivityDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		
		return dto;
	}
	
	public Activity fromDto(ActivityDto dto) {
		if (dto == null) {
			return null;
		}
		Activity entity = new Activity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		
		return entity;
	}
	
	public List<ActivityDto> toDtoList(List<Activity> entities){
		List<ActivityDto> dtos = new ArrayList<>();
		
		for (Activity entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

}
