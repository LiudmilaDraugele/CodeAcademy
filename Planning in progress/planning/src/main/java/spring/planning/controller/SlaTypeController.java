package spring.planning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.planning.dto.SlaTypeDto;
import spring.planning.service.SlaTypeService;


@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("planning/api/slatype")
public class SlaTypeController {
	
	@Autowired
	SlaTypeService service;
	
	@GetMapping("/all")
	public List<SlaTypeDto> findAllSlaTypes () {

		return service.findAllSlaTypes();    
	}

}
