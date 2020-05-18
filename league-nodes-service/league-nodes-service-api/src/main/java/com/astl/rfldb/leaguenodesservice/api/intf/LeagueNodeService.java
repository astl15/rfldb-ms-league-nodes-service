package com.astl.rfldb.leaguenodesservice.api.intf;

import java.util.List;

import com.astl.rfldb.leaguenodesservice.model.dto.LeagueNodeDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueNodeIn;
import com.astl.rfldb.leaguenodesservice.model.in.SearchLeagueNodeIn;

public interface LeagueNodeService {

	LeagueNodeDTO createLeagueNode(final LeagueNodeIn leagueNodeIn);
	
	List<LeagueNodeDTO> searchLeagueNodes(final SearchLeagueNodeIn searchLeagueNodeIn);

}
