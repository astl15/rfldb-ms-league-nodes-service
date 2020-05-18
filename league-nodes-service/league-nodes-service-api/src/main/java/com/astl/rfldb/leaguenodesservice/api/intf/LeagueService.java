package com.astl.rfldb.leaguenodesservice.api.intf;

import com.astl.rfldb.leaguenodesservice.model.dto.LeagueDTO;
import com.astl.rfldb.leaguenodesservice.model.dto.SearchLeagueDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueIn;
import com.astl.rfldb.leaguenodesservice.model.in.SearchLeagueIn;

public interface LeagueService {

	LeagueDTO createLeague(final LeagueIn leagueIn);
	
	SearchLeagueDTO searchLeagues(final SearchLeagueIn searchLeagueIn);
	
}
