package com.astl.rfldb.leaguenodesservice.business.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astl.rfldb.leaguenodesservice.business.dao.utils.LeagueProjection;
import com.astl.rfldb.leaguenodesservice.business.entity.League;

@Repository
public interface LeagueRepository extends JpaRepository<League,Long>{
	
	League findByLeagueName(final String leagueName);
	
	Page<LeagueProjection> findPagedProjectedBy(Pageable pageable);
	
}
