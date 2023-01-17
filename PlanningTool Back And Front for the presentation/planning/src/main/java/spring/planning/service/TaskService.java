package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.TaskDto;
import spring.planning.entity.SlaType;
import spring.planning.entity.Task;
import spring.planning.entity.Team;
import spring.planning.mapper.TaskMapper;
import spring.planning.repository.SlaTypeRepo;
import spring.planning.repository.TaskRepo;
import spring.planning.repository.TeamRepo;



@Service
public class TaskService {
	
	@Autowired
	TaskRepo repository;
	@Autowired
	TeamRepo teamRepository;
	@Autowired
	SlaTypeRepo slaRepo;
	@Autowired
	TaskMapper mapper;

public TaskDto findById(Long id) {
		
	Task task = repository.findById(id).orElse(null);
	TaskDto taskDto = mapper.toDto(task);
		
		return taskDto;
	}

public TaskDto findByName(String name) {
	
	Task task = repository.findByName(name).orElse(null);
	TaskDto taskDto = mapper.toDto(task);
		
		return taskDto;
	}
	
	public List<TaskDto> findAllTasks(){
		
		List<Task> tasks = (ArrayList<Task>) repository.findAll();
		
		return mapper.toDtoList(tasks);
		
	}
	
	public TaskDto createTask(TaskDto dto) {
		
		Task task = mapper.fromDto(dto);
		
	
		//perkelti i mapperi, pagal DayTask pavyzdi
		
		Team teamReference = teamRepository.getReferenceById(dto.getTeamId());
		
		task.setTeam(teamReference);
		repository.save(task);
		
		return mapper.toDto(task);
		
	}
	
	public TaskDto updateTask(TaskDto dto) {
		Task task = mapper.fromDto(dto);
		repository.save(task);
		return mapper.toDto(task);
	}
	
	public void deleteTask(Long id) {
		repository.deleteById(id);
	}

	public List<TaskDto> findTasksByTeamId(Long id) {
		List<Task> tasks = repository.findAllByTeam_Id(id);
		return mapper.toDtoList(tasks);
	}
	
	public List<TaskDto> findTasksByType(String type) {
		List<Task> tasks = repository.findAllByType(type);
		return mapper.toDtoList(tasks);
	}
	
	public List<TaskDto> findTasksBySLA(Integer sla) {
		List<Task> tasks = repository.findAllBySla(sla);
		return mapper.toDtoList(tasks);
	}
	
	public List<TaskDto> findTasksByTypeAndSla(String type, Integer sla) {
	
		
		//List<Task> tasks = repository.findAllByType(type);
		///List<Task> tasks2 = repository.findAllBySla(sla);
		/// reikia kazkaip sujungt ar veiks iur taip:???? :D
		
		
		List<Task> tasks3 = repository.findAllByTypeAndSla(type, sla);
		return mapper.toDtoList(tasks3);
	}
}
