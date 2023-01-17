package spring.planning.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import spring.planning.entity.Role;

@Getter
@Setter
public class SignupDto {
	
	
	@NotBlank
	@Size(max = 6)
	private String shortname;
	@Size(min = 6, max =20)
	@NotBlank
	private String password;
	@Size(min = 6, max =20)
	@NotBlank
	private String repeatPassword;
	private String name;
	private String email;
	
	//private Integer minutes;
	//private List<Role> roles;

}
