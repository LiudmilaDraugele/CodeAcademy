package spring.planning.entity;

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
@Table (name="plan")
public class Plan {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "date")
	private String date;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name = "employee_id")
	private Employee employee;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name = "task_id")
	private Task task;
	
	private Integer count;
	private boolean marked;
	private boolean done;

}
