package spring.planning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.planning.entity.Activities;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {

	private Long id;
	private Activities name;
}
