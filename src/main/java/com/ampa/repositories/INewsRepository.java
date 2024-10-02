package com.ampa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ampa.models.New;

@Repository
public interface INewsRepository extends CrudRepository<New, Long> {

	@Query(nativeQuery = true, value = "Select * from news where news.idNew = ?")
	New findNew(Long idNew);
	
	List<New> findByTitular(String newTitular);

}
