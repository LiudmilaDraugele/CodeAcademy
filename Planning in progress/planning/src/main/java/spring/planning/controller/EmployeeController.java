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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.planning.dto.EmployeeDto;
import spring.planning.service.EmployeeService;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("planning/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/{id}")
	public EmployeeDto findById (@PathVariable Long id) {

		return service.findById(id);    
	}
	

	@GetMapping("/all")
	public List<EmployeeDto> findAllEmployees () {

		return service.findAllEmployees();    
	}
	
    //@PreAuthorize("hasRole('ADMIN') or hasRole('LEADER')")
	@PostMapping(" ")
	public EmployeeDto createEmployee(@RequestBody EmployeeDto empDto) {
		return service.createEmployee(empDto);
	}
	
//	@PutMapping ("/addteamrole/{id}/{teamId}/{roleId}/{min}")
//	public EmployeeDto updateEmployeeWithTeamRoleHours(@RequestBody EmployeeDto empDto, @PathVariable(name="id") Long id, Long teamId,Long roleId, Integer min) {
//		
//		return service.updateEmployeeWithTeamRoleHours(empDto, id, teamId, roleId, min);
//	}
	
	@PutMapping ("/addteamrole/{id}/{teamId}/{roleId}")
	public EmployeeDto updateEmployeeWithTeamRoleHours(@PathVariable(name="id") Long id,@PathVariable Long teamId,
			@PathVariable Long roleId) {
		EmployeeDto empDto = service.findById(id);
		System.out.println(id);
		System.out.println(empDto);
		EmployeeDto updatedemployee = service.updateEmployeeWithTeamRole(empDto, id, teamId, roleId);
		System.out.println(empDto);
		return updatedemployee;
	}
	
	@PutMapping ("/addhours")
	public EmployeeDto updateEmployeeWithTeamRoleHours(@RequestParam Long id, Integer min) {
		
		EmployeeDto empDto = service.findById(id);
		System.out.println(id);
		System.out.println(empDto);
		EmployeeDto updatedemployee = service.updateEmployeeWithHours(empDto, id, min);
		
		return updatedemployee;
	}
	
	@PutMapping ("/changepass/{id}")
	public EmployeeDto updatePassword(@RequestBody EmployeeDto empDto, @PathVariable(name="id") Long id) {
		//empDto = service.findById(id);
		//System.out.println(id);
		//System.out.println(empDto);
		EmployeeDto updatedemployee = service.updateEmployeePassword(empDto, id);
		System.out.println(empDto);
		return updatedemployee;
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('LEADER')")
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		}
	
	
	
//	@GetMapping("/bypersonalcode/{code}")
//	public EmployeeDto findByTaskId (@PathVariable Long id) {
//
//		return service.findByTask_Id(id);    
//	}
	
	@GetMapping("/byteam/{id}")
	public List<EmployeeDto> findEmployesByTeamId(@PathVariable Long id){
		return service.findEmployesByTeamId(id);
	}

}
