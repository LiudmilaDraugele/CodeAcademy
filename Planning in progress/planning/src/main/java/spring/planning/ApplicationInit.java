package spring.planning;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import spring.planning.entity.Activities;
import spring.planning.entity.Activity;
import spring.planning.entity.Employee;
import spring.planning.entity.Role;
import spring.planning.entity.Roles;
import spring.planning.entity.SlaType;
import spring.planning.entity.Type;
import spring.planning.repository.ActivityRepo;
import spring.planning.repository.EmployeeRepo;
import spring.planning.repository.RoleRepo;
import spring.planning.repository.SlaTypeRepo;

@Component
public class ApplicationInit implements ApplicationRunner {
	
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	SlaTypeRepo slaRepo;
	@Autowired
	EmployeeRepo empRepo;
	@Autowired
	ActivityRepo actRepo;
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	
	public void run(ApplicationArguments args) throws Exception{
		
		Role admin = new Role();
		admin.setName(Roles.ROLE_ADMIN);
		
		if(roleRepo.findByName(Roles.ROLE_ADMIN).isEmpty()) {
			roleRepo.save(admin);
		}
		
		if(roleRepo.findByName(Roles.ROLE_LEADER).isEmpty()) {
			Role leader = new Role();
			leader.setName(Roles.ROLE_LEADER);
			roleRepo.save(leader);	
		}
		if(roleRepo.findByName(Roles.ROLE_PLANNER).isEmpty()) {
			Role planner = new Role();
			planner.setName(Roles.ROLE_PLANNER);
			roleRepo.save(planner);	
		}
		if(roleRepo.findByName(Roles.ROLE_USER).isEmpty()) {
			Role user = new Role();
			user.setName(Roles.ROLE_USER);
			roleRepo.save(user);	
		}
		
		if(empRepo.findByShortname("LIDR").isEmpty()) {
			Employee god = new Employee();
			god.setShortname("LIDR");
			god.setName("Liudmila");
			god.setEmail("admin@myemail.com");
			god.setMinutes(420);
			List<Role> roles = new ArrayList<>();
			roles.add(admin);
			god.setRoles(roles);
			god.setPassword(encoder.encode("IamAdmin"));
			god.setTeam(null);
			god.setActive(true);
			empRepo.save(god);	
		}
		
		if(slaRepo.findByType(Type.EXTERNAL).isEmpty()) {
			SlaType external = new SlaType();
			external.setType(Type.EXTERNAL);
			slaRepo.save(external);	
		}
		if(slaRepo.findByType(Type.INTERNAL).isEmpty()) {
			SlaType internal = new SlaType();
			internal.setType(Type.INTERNAL);
			slaRepo.save(internal);	
		}
		
		if(actRepo.findByName(Activities.TRAININGS).isEmpty()) {
			Activity train = new Activity();
			train.setName(Activities.TRAININGS);
			actRepo.save(train);	
		}
		if(actRepo.findByName(Activities.LEAN).isEmpty()) {
			Activity lean = new Activity();
			lean.setName(Activities.LEAN);
			actRepo.save(lean);	
		}
		if(actRepo.findByName(Activities.MEETINGS).isEmpty()) {
			Activity meet = new Activity();
			meet.setName(Activities.MEETINGS);
			actRepo.save(meet);	
		}
		if(actRepo.findByName(Activities.ABSENCES).isEmpty()) {
			Activity absent = new Activity();
			absent.setName(Activities.ABSENCES);
			actRepo.save(absent);	
		}
		if(actRepo.findByName(Activities.OPTIONAL).isEmpty()) {
			Activity option = new Activity();
			option.setName(Activities.OPTIONAL);
			actRepo.save(option);	
		}
		
		
	}
}
