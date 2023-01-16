package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.PlanDto;
import spring.planning.entity.Plan;
import spring.planning.mapper.PlanMapper;
import spring.planning.repository.PlanRepo;



@Service
public class PlanService {
	
	@Autowired
	PlanRepo repository;
	@Autowired
	PlanMapper mapper;
	
	public PlanDto findById(Long id) {
		
		Plan entity = repository.findById(id).orElse(null);
		PlanDto dto = mapper.toDto(entity);
		
		return dto;
	}
	
	public List<PlanDto> findAllPlans(){
		
		List<Plan> plans = (ArrayList<Plan>) repository.findAll();
		
		return mapper.toDtoList(plans);
		
	}
	
	public PlanDto createPlan(PlanDto dto) {
		
		Plan entity = mapper.fromDto(dto);
		repository.save(entity);
		
		return mapper.toDto(entity);
		
	}
	
	public PlanDto updatePlan(PlanDto dto, Long id) {
		Plan entity = mapper.fromDto(dto);
		repository.save(entity);
		
		return mapper.toDto(entity);
	}
	
	public void deletePlan(Long id) {
		repository.deleteById(id);
	}
	
	public List<PlanDto> findPlanByDate(String date) {
		List<Plan> planlistbydate = repository.findAllByDate(date);
		return mapper.toDtoList(planlistbydate);
	}

}
