package com.astl.rfldb.leaguenodesservice.business.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.astl.rfldb.leaguenodesservice.business.dao.utils.LeagueProjection;
import com.astl.rfldb.leaguenodesservice.business.entity.League;

public interface LeagueDAO {

	League createLeague(final League league);
	
	League findLeagueByLeagueName(final String leagueName);
	
	Page<LeagueProjection> findPagedProjectedBy(Pageable pageable);
	
}
