package spring.planning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.planning.dto.ActivityDto;
import spring.planning.service.ActivityService;


@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("planning/api/activity")
public class ActivityController {
	
	@Autowired
	ActivityService service;
	
	@GetMapping("/all")
	public List<ActivityDto> findAllActivities () {

		return service.findAllActivities();    
	}

}
