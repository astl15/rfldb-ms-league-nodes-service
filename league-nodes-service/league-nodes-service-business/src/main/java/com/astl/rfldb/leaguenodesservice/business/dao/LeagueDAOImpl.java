package com.astl.rfldb.leaguenodesservice.business.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.astl.rfldb.leaguenodesservice.business.dao.utils.LeagueProjection;
import com.astl.rfldb.leaguenodesservice.business.entity.League;

@Component
public class LeagueDAOImpl implements LeagueDAO {
	
	@Autowired
	private LeagueRepository leagueRepository;

	@Override
	public League createLeague(League league) {
		return leagueRepository.save(league);
	}

	@Override
	public League findLeagueByLeagueName(String leagueName) {
		return leagueRepository.findByLeagueName(leagueName);
	}

	@Override
	public Page<LeagueProjection> findPagedProjectedBy(Pageable pageable) {
		return leagueRepository.findPagedProjectedBy(pageable);
	}

}
