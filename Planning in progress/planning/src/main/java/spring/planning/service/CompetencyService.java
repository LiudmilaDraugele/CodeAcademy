package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.CompetencyDto;
import spring.planning.entity.Competency;
import spring.planning.mapper.CompetencyMapper;
import spring.planning.repository.CompetencyRepo;


@Service
public class CompetencyService {


	@Autowired
	CompetencyRepo repository;
	@Autowired
	CompetencyMapper mapper;
	
	public CompetencyDto findById(Long id) {
		
		Competency entity = repository.findById(id).orElse(null);
		CompetencyDto dto = mapper.toDto(entity);
		
		return dto;
	}
	
	public List<CompetencyDto> findAllCompetencies(){
		
		List<Competency> competencies = (ArrayList<Competency>) repository.findAll();
		
		return mapper.toDtoList(competencies);
		
	}
	
	public CompetencyDto createCompetency(CompetencyDto dto) {
		
		Competency entity = mapper.fromDto(dto);
		repository.save(entity);
		
		return mapper.toDto(entity);
		
	}
	
	public CompetencyDto updateCompetency(CompetencyDto dto, Long id) {
		Competency entity = repository.findById(id).orElse(null);
		entity.setLevel(dto.getLevel());
		repository.save(entity);
		return mapper.toDto(entity);
	}
	
	public void deleteCompetency(Long id) {
		repository.deleteById(id);
	}
}
