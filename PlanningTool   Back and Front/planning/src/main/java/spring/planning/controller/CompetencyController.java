package spring.planning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.planning.dto.CompetencyDto;
import spring.planning.service.CompetencyService;


@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("planning/api/competency")
public class CompetencyController {
	
	@Autowired
	CompetencyService service;

	@GetMapping("/{id}")
	public CompetencyDto findById (@PathVariable Long id) {

		return service.findById(id);    
	}
	
	@GetMapping("/all")
	public List<CompetencyDto> findAllTeams () {

		return service.findAllCompetencies();    
	}
	
    //@PreAuthorize("hasRole('ADMIN') or hasRole('LEADER')")
	@PostMapping("/create")
	public CompetencyDto createCompetency(@RequestBody CompetencyDto dto) {
		return service.createCompetency(dto);
	}
	
	@PutMapping ("/{id}")
	public CompetencyDto updateCompetency(@RequestBody CompetencyDto dto, @PathVariable(name="id") Long id) {
		
		return service.updateCompetency(dto, id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_LEADER')or hasRole('ROLE_PLANNER')")
	@DeleteMapping("/{id}")
	public void deleteCompetency(@PathVariable Long id) {
		service.deleteCompetency(id);
		}

}
