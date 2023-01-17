package spring.planning.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
	@NotBlank
	private String shortname;
	@NotBlank
	private String password;

}
