package spring.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.TeamDto;
import spring.planning.entity.Team;
import spring.planning.mapper.TeamMapper;
import spring.planning.repository.TeamRepo;


@Service
public class TeamService {
	
	@Autowired
	TeamRepo repository;
	@Autowired
	TeamMapper mapper;
	
	public TeamDto findById(Long id) {
		
		Team team = repository.findById(id).orElse(null);
		TeamDto teamDto = mapper.toDto(team);
		
		return teamDto;
	}
	
	public List<TeamDto> findAllTeams(){
		
		List<Team> teams = (ArrayList<Team>) repository.findAll();
		
		return mapper.toDtoList(teams);
		
	}
	
	public TeamDto createTeam(TeamDto teamDto) {
		
		Team team = mapper.fromDto(teamDto);
		repository.save(team);
		
		return mapper.toDto(team);
		
	}
	
	public TeamDto updateTeam(TeamDto teamDto, Long id) {
		Team team = repository.findById(id).orElse(null);
		team.setName(teamDto.getName());
		repository.save(team);
		return mapper.toDto(team);
	}
	
	public void deleteTeam(Long id) {
		repository.deleteById(id);
	}


}
