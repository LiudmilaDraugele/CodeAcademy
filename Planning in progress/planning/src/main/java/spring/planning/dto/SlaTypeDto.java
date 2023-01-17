package spring.planning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.planning.entity.SlaType;
import spring.planning.entity.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlaTypeDto {
	
	private Long id;
	private Type type;

}
