package spring.planning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.planning.dto.PlanDto;
import spring.planning.service.PlanService;


@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("planning/api/plan")
public class PlanController {
	
	@Autowired
	PlanService service;

	@GetMapping("/{id}")
	public PlanDto findById (@PathVariable Long id) {

		return service.findById(id);    
	}
	
	@GetMapping("/all")
	public List<PlanDto> findAllPlans () {

		return service.findAllPlans();    
	}
	
    
	@PostMapping("/create")
	public PlanDto createAdditional(@RequestBody PlanDto dto) {
		return service.createPlan(dto);
	}
	
	@PutMapping ("/{id}")
	public PlanDto updatePlan(@RequestBody PlanDto dto, @PathVariable(name="id") Long id) {
		
		return service.updatePlan(dto, id);
	}
	
	
	@DeleteMapping("/{id}")
	public void deletePlan(@PathVariable Long id) {
		service.deletePlan(id);
		}
	
	@GetMapping("/bydate/{date}")
	public List<PlanDto> findPlanByDate(@PathVariable String date){
		return service.findPlanByDate(date);
	}

}
