package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import spring.planning.dto.EmployeeDto;
import spring.planning.dto.SignupDto;
import spring.planning.entity.Employee;
import spring.planning.entity.Role;
import spring.planning.entity.Roles;
import spring.planning.mapper.EmployeeMapper;
import spring.planning.repository.EmployeeRepo;
import spring.planning.repository.RoleRepo;

@Service
public class AuthService {
	
	
	@Autowired
	EmployeeRepo empRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	EmployeeMapper empMapper;
	@Autowired
	PasswordEncoder encoder;
	
public EmployeeDto signup(SignupDto signupDto) throws Exception {
		
		if(empRepo.findByShortname(signupDto.getShortname()).isPresent()){
			throw new Exception ("Shortname "+signupDto.getShortname() + " is already in use");
			
		}
		
		if (!signupDto.getPassword().equals(signupDto.getRepeatPassword())) {
			throw new Exception ("Passwords do not match");
		}
		
		Employee newUser = new Employee();
		newUser.setShortname(signupDto.getShortname());
		newUser.setPassword(encoder.encode(signupDto.getPassword()));
		newUser.setName(signupDto.getName());
		newUser.setEmail(signupDto.getEmail());
		//newUser.setMinutes(signupDto.getMinutes());
	
		
		//Role userRole = roleRepo.findByName(Roles.ROLE_USER).orElseThrow();
		
		//<Role> userRoles = new ArrayList<>();
		//userRoles.add(userRole);
		//newUser.setRoles(userRoles);
		empRepo.save(newUser);
		
		return empMapper.toDto(newUser);
		
	}

}
