package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.SlaTypeDto;
import spring.planning.entity.SlaType;
import spring.planning.repository.SlaTypeRepo;


@Service
public class SlaTypeMapper {
	
	@Autowired
	SlaTypeRepo repository;
	
	public SlaTypeDto toDto(SlaType entity) {
		if (entity == null) {
			return null;
		}
		SlaTypeDto dto = new SlaTypeDto();
		dto.setId(entity.getId());
		dto.setType(entity.getType());
		
		return dto;
	}
	
	public SlaType fromDto(SlaTypeDto dto) {
		if (dto == null) {
			return null;
		}
		SlaType entity = new SlaType();
		entity.setId(dto.getId());
		entity.setType(dto.getType());
		
	
		return entity;
	}
	
	public List<SlaTypeDto> toDtoList(List<SlaType> entities){
		List<SlaTypeDto> dtos = new ArrayList<>();
		
		for (SlaType entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

}
