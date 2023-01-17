package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.SlaTypeDto;
import spring.planning.entity.SlaType;
import spring.planning.mapper.SlaTypeMapper;
import spring.planning.repository.SlaTypeRepo;

@Service
public class SlaTypeService {
	
	@Autowired
	SlaTypeRepo repository;
	@Autowired
	SlaTypeMapper mapper;
	
	public SlaTypeDto findById(Long id) {
		
		SlaType sla = repository.findById(id).orElse(null);
		SlaTypeDto dto = mapper.toDto(sla);
		
		return dto;
	}
	
	public List<SlaTypeDto> findAllSlaTypes(){
		
		List<SlaType> types = (ArrayList<SlaType>) repository.findAll();
		
		return mapper.toDtoList(types);
		
	}

}
