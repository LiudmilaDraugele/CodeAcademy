package spring.planning.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.planning.entity.Task;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountingDto {
	
	private Long id;
	private String date;
	private Integer count;
	private Long taskId;
	private String comment;
	private String taskName;

}
