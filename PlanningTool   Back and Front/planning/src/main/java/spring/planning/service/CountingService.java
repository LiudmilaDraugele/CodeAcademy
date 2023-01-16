package spring.planning.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.planning.dto.CountingDto;
import spring.planning.entity.Counting;
import spring.planning.mapper.CountingMapper;
import spring.planning.repository.CountingRepo;

@Service
public class CountingService {
	
	@Autowired
	CountingRepo repository;
	@Autowired
	CountingMapper mapper;
	
public CountingDto findById(Long id) {
		
	Counting count = repository.findById(id).orElse(null);
	CountingDto dto = mapper.toDto(count);
		
		return dto;
	}
	
	public List<CountingDto> findAllCounting(){
		
		List<Counting> countlist = (ArrayList<Counting>) repository.findAll();
		
		return mapper.toDtoList(countlist);
		
	}
	
	public CountingDto createCounting(CountingDto dto) {
		
		Counting count = mapper.fromDto(dto);
		repository.save(count);
		
		return mapper.toDto(count);
		
	}
	
	public CountingDto updateCounting(CountingDto dto, Long id) {
		Counting count = mapper.fromDto(dto);
		repository.save(count);
		return mapper.toDto(count);
	}
	
	public void deleteCounting(Long id) {
		repository.deleteById(id);
	}

	public List<CountingDto> findCountingByDate(String date) {
		List<Counting> countlistbydate = repository.findAllByDate(date);
		return mapper.toDtoList(countlistbydate);
	}
	

}
