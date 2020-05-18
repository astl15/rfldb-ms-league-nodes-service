package com.astl.rfldb.leaguenodesservice.business.dao;

import java.util.List;

import com.astl.rfldb.leaguenodesservice.business.entity.LeagueNode;

public interface LeagueNodeDAO {
	
	LeagueNode createLeagueNode(final LeagueNode leagueNode);
	
	LeagueNode findLeagueNodeByNodeName(final String nodeName);
	
	Long getCountryLastLeagueNodeIndex(final Long countryId);
	
	List<LeagueNode> searchLeagueNodes(final Long countryId);
	
}
