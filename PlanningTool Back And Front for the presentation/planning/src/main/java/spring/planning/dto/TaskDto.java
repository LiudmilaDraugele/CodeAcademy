package spring.planning.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import spring.planning.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
	
	private Long id;
	@NotBlank (message = "Name should not be blank")
	private String name;
	private Integer minutes;
	@Enumerated(EnumType.STRING)
	private Type type;
	private Integer sla;
	private	Long teamId;
}
