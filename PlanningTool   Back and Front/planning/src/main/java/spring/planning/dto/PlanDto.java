package spring.planning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDto {
	
	private Long id;
	private String date;
	private Long employeeId;
	private Long taskId;
	private Integer count;
	private boolean marked;
	private boolean done;

}
