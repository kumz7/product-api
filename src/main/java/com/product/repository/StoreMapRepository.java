package com.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.model.StoreMap;

@Repository
public interface StoreMapRepository extends CrudRepository<StoreMap, Long>{
	
	@Query("from StoreMap where key=:key ")
	public Optional<List<StoreMap>> getMapByKey(@Param("key") String key);

}
