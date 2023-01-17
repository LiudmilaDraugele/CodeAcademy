package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.ActivityDto;
import spring.planning.entity.Activity;
import spring.planning.mapper.ActivityMapper;
import spring.planning.repository.ActivityRepo;


@Service
public class ActivityService {
	
	@Autowired
	ActivityRepo repository;
	@Autowired
	ActivityMapper mapper;
	
public ActivityDto findById(Long id) {
		
	Activity entity = repository.findById(id).orElse(null);
	ActivityDto dto = mapper.toDto(entity);
		
		return dto;
	}
	
public List<ActivityDto> findAllActivities(){
		
		List<Activity> activities = (ArrayList<Activity>) repository.findAll();
		
		return mapper.toDtoList(activities);
		
	}

}
