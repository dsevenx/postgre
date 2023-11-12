package com.dsevenx.d7xpostgresql.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KeyValueRepo extends JpaRepository<TMOTORKEYVALUE, String>{

	
	@Query("Select c from TMOTORKEYVALUE c where c.mSuchfilterdb like %:suchfilter%")
	List<TMOTORKEYVALUE> findBySuchfilter(@Param("suchfilter")String suchfilter);
	
	@Query("Select c from TMOTORKEYVALUE c where c.mSuchfilterdb like %:suchfilter%  AND c.mClusterdb = :cluster")
	List<TMOTORKEYVALUE> findByClusterAndSuchFilter(@Param("cluster")String cluster,@Param("suchfilter")String suchfilter);

}

