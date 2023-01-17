package spring.planning.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.planning.entity.Team;
import spring.planning.entity.Role;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="employee")
public class Employee {

		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column
		private String shortname;
		@Column
		private String name;
		@Column
		private	String email;
		
		@Column(name="password")
		private String password;
		
//		@OneToMany (cascade =CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creator") 
//		private List<ToDoTask> tasks;
//		
		//@Enumerated(EnumType.STRING)
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name="employee_roles",
		joinColumns= @JoinColumn(name = "employee_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
		private List<Role> roles = new ArrayList<>();
		
		@ManyToOne(cascade = CascadeType.MERGE)
		//@JoinColumn (name = "team_id")
		private Team team;
		
		@Column(name="active")
		private Boolean active;
		
		@Column (name="minutes")
		private Integer minutes;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getShortname() {
			return shortname;
		}

		public void setShortname(String shortname) {
			this.shortname = shortname;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<Role> getRoles() {
			return roles;
		}

		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}

		public Team getTeam() {
			return team;
		}

		public void setTeam(Team team) {
			this.team = team;
		}

		public Integer getMinutes() {
			return minutes;
		}

		public void setMinutes(Integer minutes) {
			this.minutes = minutes;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}
		
		

	}

