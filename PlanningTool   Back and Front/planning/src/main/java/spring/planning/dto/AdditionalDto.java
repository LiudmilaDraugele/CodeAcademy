package spring.planning.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalDto {
	
	private Long id;
	private String date;
	private Long employeeId;
	private Integer duration;
	private String comment;
	
	private	Long activityId;
	

}
