package spring.planning.controller;

import java.util.Date;
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

import spring.planning.dto.CountingDto;
import spring.planning.service.CountingService;



@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("planning/api/counting")
public class CountingController {
	
	@Autowired
	CountingService service;
	
	@GetMapping("/{id}")
	public CountingDto findById (@PathVariable Long id) {

		return service.findById(id);    
	}
	

	@GetMapping("/all")
	public List<CountingDto> findAllDayTasks () {

		return service.findAllCounting();    
	}
	
    //@PreAuthorize("hasRole('ADMIN') or hasRole('LEADER')")
	@PostMapping("/create")
	public CountingDto createCounting(@RequestBody CountingDto dto) {
		return service.createCounting(dto);
	}
	
	@PutMapping ("/{id}")
	public CountingDto updateCounting(@RequestBody CountingDto dto, @PathVariable(name="id") Long id) {
		
		return service.updateCounting(dto, id);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('LEADER')")
	@DeleteMapping("/{id}")
	public void deleteCounting(@PathVariable Long id) {
		service.deleteCounting(id);
		}
	
//	@GetMapping("/bypersonalcode/{code}")
//	public EmployeeDto findByTaskId (@PathVariable Long id) {
//
//		return service.findByTask_Id(id);    
//	}
	
	@GetMapping("/bydate/{date}")
	public List<CountingDto> findCountingByDate(@PathVariable String date){
		return service.findCountingByDate(date);
	}

}
