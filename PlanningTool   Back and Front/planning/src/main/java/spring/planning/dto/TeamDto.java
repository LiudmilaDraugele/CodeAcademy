package spring.planning.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
	
	private Long id;
	private String name;
	
	private List<EmployeeDto> employees;
	
	private List<TaskDto> tasks;

}
