package spring.planning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetencyDto {
	
	private Long id;
	
	private	Long employeeId;
	private	Long taskId;
	private	Integer level;

}
