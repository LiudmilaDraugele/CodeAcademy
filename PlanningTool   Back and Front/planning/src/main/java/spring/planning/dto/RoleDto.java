package spring.planning.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.planning.entity.Roles;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
	
	private Long id;
	private Roles name;

}
