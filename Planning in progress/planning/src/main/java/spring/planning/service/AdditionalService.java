package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.AdditionalDto;
import spring.planning.entity.Additional;
import spring.planning.mapper.AdditionalMapper;
import spring.planning.repository.AdditionalRepo;


@Service
public class AdditionalService {
	
	@Autowired
	AdditionalRepo repository;
	@Autowired
	AdditionalMapper mapper;
	
	public AdditionalDto findById(Long id) {
		
		Additional entity = repository.findById(id).orElse(null);
		AdditionalDto dto = mapper.toDto(entity);
		
		return dto;
	}
	
	public List<AdditionalDto> findAllAdditional(){
		
		List<Additional> times = (ArrayList<Additional>) repository.findAll();
		
		return mapper.toDtoList(times);
		
	}
	
	public AdditionalDto createAdditional(AdditionalDto dto) {
		
		Additional entity = mapper.fromDto(dto);
		repository.save(entity);
		
		return mapper.toDto(entity);
		
	}
	
	public AdditionalDto updateAdditional(AdditionalDto dto, Long id) {
		Additional entity = mapper.fromDto(dto);
		
		
		
		repository.save(entity);
		
		return mapper.toDto(entity);
	}
	
	public void deleteAdditional(Long id) {
		repository.deleteById(id);
	}
	
	public List<AdditionalDto> findAdditionalByDate(String date) {
		List<Additional> timeslistbydate = repository.findAllByDate(date);
		return mapper.toDtoList(timeslistbydate);
	}

}
