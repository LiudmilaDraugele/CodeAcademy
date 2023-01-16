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

import spring.planning.dto.TeamDto;
import spring.planning.service.TeamService;



@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("planning/api/team")
public class TeamController {
	
	@Autowired
	TeamService service;

	@GetMapping("/{id}")
	public TeamDto findById (@PathVariable Long id) {

		return service.findById(id);    
	}
	

	@GetMapping("/all")
	public List<TeamDto> findAllTeams () {

		return service.findAllTeams();    
	}
	
    //@PreAuthorize("hasRole('ADMIN') or hasRole('LEADER')")
	@PostMapping("/create")
	public TeamDto createTeam(@RequestBody TeamDto teamDto) {
		return service.createTeam(teamDto);
	}
	
	@PutMapping ("/{id}")
	public TeamDto updateTeam(@RequestBody TeamDto teamDto, @PathVariable(name="id") Long id) {
		
		return service.updateTeam(teamDto, id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_LEADER')")
	@DeleteMapping("/{id}")
	public void deleteTeam(@PathVariable Long id) {
		service.deleteTeam(id);
		}
	
	
}
