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

import spring.planning.dto.TaskDto;
import spring.planning.service.TaskService;



@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("planning/api/task")
public class TaskController {
	
	@Autowired
	TaskService service;
	
	@GetMapping("/{id}")
	public TaskDto findById (@PathVariable Long id) {

		return service.findById(id);    
	}
	
	@GetMapping("/byname/{name}")
	public TaskDto findByName (@PathVariable String name) {

		return service.findByName(name);    
	}

	@GetMapping("/all")
	public List<TaskDto> findAllEmployees () {

		return service.findAllTasks();    
	}
	
    //@PreAuthorize("hasRole('ADMIN') or hasRole('LEADER')")
	@PostMapping("/create")
	public TaskDto createTask(@RequestBody TaskDto dto) {
		return service.createTask(dto);
	}
	
	@PutMapping ("/{id}")
	public TaskDto updateTask(@RequestBody TaskDto dto, @PathVariable(name="id") Long id) {
		
		return service.updateTask(dto);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('LEADER')")
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		service.deleteTask(id);
		}

	
	@GetMapping("/byteam/{id}")
	public List<TaskDto> findTasksByTeamId(@PathVariable Long id){
		return service.findTasksByTeamId(id);
	}

}
