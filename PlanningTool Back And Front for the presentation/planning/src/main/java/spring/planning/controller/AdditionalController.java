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

import spring.planning.dto.AdditionalDto;
import spring.planning.dto.CountingDto;
import spring.planning.service.AdditionalService;



@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("planning/api/additional")
public class AdditionalController {
	
	@Autowired
	AdditionalService service;

	@GetMapping("/{id}")
	public AdditionalDto findById (@PathVariable Long id) {

		return service.findById(id);    
	}
	
	@GetMapping("/all")
	public List<AdditionalDto> findAllAdditional () {

		return service.findAllAdditional();    
	}
	
    
	@PostMapping("/create")
	public AdditionalDto createAdditional(@RequestBody AdditionalDto dto) {
		return service.createAdditional(dto);
	}
	
	@PutMapping ("/{id}")
	public AdditionalDto updateAdditional(@RequestBody AdditionalDto dto, @PathVariable(name="id") Long id) {
		
		return service.updateAdditional(dto, id);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteAdditional(@PathVariable Long id) {
		service.deleteAdditional(id);
		}
	
	@GetMapping("/bydate/{date}")
	public List<AdditionalDto> findAdditionalByDate(@PathVariable String date){
		return service.findAdditionalByDate(date);
	}

}
