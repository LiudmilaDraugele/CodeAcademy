package spring.planning.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.RoleDto;
import spring.planning.entity.Role;
import spring.planning.entity.Roles;
import spring.planning.entity.Task;
import spring.planning.repository.RoleRepo;


@Service
public class RoleMapper {
	
	@Autowired
	RoleRepo roleRepo;
	
	public RoleDto toDto(Role entity) {
		if (entity == null) {
			return null;
		}
		RoleDto dto = new RoleDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		
		return dto;
	}
	
	public Role fromDto(RoleDto dto) {
		if (dto == null) {
			return null;
		}
		Role entity = new Role();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		
	
		return entity;
	}
	
	public List<RoleDto> toDtoList(List<Role> entities){
		List<RoleDto> dtos = new ArrayList<>();
		
		for (Role entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

}
