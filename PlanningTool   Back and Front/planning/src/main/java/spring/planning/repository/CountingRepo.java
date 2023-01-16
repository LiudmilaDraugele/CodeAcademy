package spring.planning.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import spring.planning.entity.Counting;


public interface CountingRepo extends CrudRepository<Counting, Long> {
	
	public List<Counting> findAllByDate(String date);

}
