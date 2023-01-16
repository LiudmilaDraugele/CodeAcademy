package spring.planning.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private Long id;
	@NotBlank (message = "Shortname should not be blank")
	private String shortname;
	@NotBlank (message = "Name should not be blank")
	private String name;
	@Email (message = "Wrong email format")
	private String email;
	
	private	Long teamId;
	
	private Integer minutes;
	
	private RoleDto role;
	
	private String password;
	
	

}
