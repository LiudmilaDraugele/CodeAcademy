package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.EmployeeDto;
import spring.planning.dto.RoleDto;
import spring.planning.entity.Employee;
import spring.planning.entity.Role;
import spring.planning.mapper.RoleMapper;
import spring.planning.repository.RoleRepo;


@Service
public class RoleService {
	
	@Autowired
	RoleRepo repository;
	@Autowired
	RoleMapper mapper;
	
public RoleDto findById(Long id) {
		
		Role entity = repository.findById(id).orElse(null);
		RoleDto dto = mapper.toDto(entity);
		
		return dto;
	}
	
public List<RoleDto> findAllRoles(){
		
		List<Role> roles = (ArrayList<Role>) repository.findAll();
		
		return mapper.toDtoList(roles);
		
	}

}
