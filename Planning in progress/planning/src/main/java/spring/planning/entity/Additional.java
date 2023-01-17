package spring.planning.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="additional")
public class Additional {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name = "date")
	private String date;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name = "employee_id")
	private Employee employee;
	@Column
	private Integer duration;
	@Column
	private String comment;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Activity activity;
	

}
