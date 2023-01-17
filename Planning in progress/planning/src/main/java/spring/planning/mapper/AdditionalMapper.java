package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.AdditionalDto;
import spring.planning.entity.Activity;
import spring.planning.entity.Additional;
import spring.planning.entity.Employee;
import spring.planning.repository.ActivityRepo;
import spring.planning.repository.EmployeeRepo;



@Service
public class AdditionalMapper {
	
	@Autowired 
	EmployeeRepo employeeRepo;
	@Autowired 
	ActivityRepo actRepo;

	
	public AdditionalDto toDto(Additional entity) {
		if (entity == null) {
			return null;
		}
		AdditionalDto dto = new AdditionalDto();
		dto.setId(entity.getId());
		dto.setDate(entity.getDate());
		dto.setDuration(entity.getDuration());
		dto.setEmployeeId(entity.getEmployee().getId());
		dto.setComment(entity.getComment());
		dto.setActivityId(entity.getActivity().getId());
		
		return dto;
	}
	
	public Additional fromDto(AdditionalDto dto) {
		if (dto == null) {
			return null;
		}
		Additional entity = new Additional();
		entity.setId(dto.getId());
		entity.setDate(dto.getDate());
		entity.setDuration(dto.getDuration());
		Employee employeeReference = employeeRepo.getReferenceById(dto.getEmployeeId());
		entity.setEmployee(employeeReference);
		entity.setComment(dto.getComment());
		
		Activity actReference = actRepo.getReferenceById(dto.getActivityId());
		entity.setActivity(actReference);
	
		return entity;
	}
	
	public List<AdditionalDto> toDtoList(List<Additional> entities){
		List<AdditionalDto> dtos = new ArrayList<>();
		
		for (Additional entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

}
