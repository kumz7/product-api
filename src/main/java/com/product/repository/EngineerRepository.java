package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.model.Engineer;

@Repository
public interface EngineerRepository extends CrudRepository<Engineer, Long> {

	@Query("from Engineer where contact like %:key% or name like %:key% ")
	public List<Engineer> fetchEngineerBySearch(@Param("key") String key);
	
}
