package com.astl.rfldb.leaguenodesservice.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.astl.rfldb.leaguenodesservice.api.intf.LeagueService;
import com.astl.rfldb.leaguenodesservice.business.dao.utils.LeagueProjection;
import com.astl.rfldb.leaguenodesservice.business.entity.League;
import com.astl.rfldb.leaguenodesservice.business.manager.LeagueManager;
import com.astl.rfldb.leaguenodesservice.business.mapper.LeagueMapper;
import com.astl.rfldb.leaguenodesservice.model.dto.LeagueDTO;
import com.astl.rfldb.leaguenodesservice.model.dto.SearchLeagueDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueIn;
import com.astl.rfldb.leaguenodesservice.model.in.SearchLeagueIn;

@Component
public class LeagueServiceImpl implements LeagueService {
	
	@Autowired
	private LeagueManager leagueManager;

	@Override
	public LeagueDTO createLeague(final LeagueIn leagueIn) {
		return LeagueMapper.mapFrom(leagueManager.createLeague(leagueIn));
	}

	@Override
	public SearchLeagueDTO searchLeagues(final SearchLeagueIn searchLeagueIn) {
		if(searchLeagueIn != null) {
			SearchLeagueDTO output = new SearchLeagueDTO();
			if(searchLeagueIn.getLeagueName() != null) {
				League league = leagueManager.findLeaguebyLeagueName(searchLeagueIn.getLeagueName());
				if(league != null) {
					List<LeagueDTO> leagues = new ArrayList<>();
					leagues.add(LeagueMapper.mapFrom(league));
					output.setTotalElements(1);
					output.setLeagues(leagues);
				}
				return output;
				
			}else if(searchLeagueIn.getPageNumber() >= 0 && 
					searchLeagueIn.getNrOfResultsPerPage() > 0) {
				Page<LeagueProjection> pagedLeagues = leagueManager.searchLeagues(searchLeagueIn);
				if(pagedLeagues != null && pagedLeagues.hasContent()) {
					List<LeagueProjection> projectedLeagues = pagedLeagues.getContent();
					if(!projectedLeagues.isEmpty()) {
						List<LeagueDTO> leagues = new ArrayList<>();
						projectedLeagues.forEach(projectedLeague -> {
							LeagueDTO league = LeagueMapper.mapFrom(projectedLeague);
							leagues.add(league);
						});
						output.setTotalElements(searchLeagueIn.getNrOfResultsPerPage() * pagedLeagues.getTotalPages());
						output.setLeagues(leagues);
						return output;
					}
				}
			}
		}
			
		return null;
	}

}
