package com.astl.rfldb.leaguenodesservice.business.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.astl.rfldb.leaguenodesservice.business.entity.LeagueNode;

@Component
public class LeagueNodeDAOImpl implements LeagueNodeDAO {
	
	@Autowired
	private LeagueNodeRepository leagueNodeRepository;

	@Override
	public LeagueNode createLeagueNode(final LeagueNode leagueNode) {
		return leagueNodeRepository.save(leagueNode);
	}

	@Override
	public LeagueNode findLeagueNodeByNodeName(final String nodeName) {
		return leagueNodeRepository.findByNodeName(nodeName);
	}

	@Override
	public Long getCountryLastLeagueNodeIndex(final Long countryId) {
		List<LeagueNode> leagueNodes = leagueNodeRepository.findByNodeCountryId(countryId);
		if(leagueNodes != null && !leagueNodes.isEmpty()) {
			return leagueNodes.get(leagueNodes.size() - 1).getNodeId();
		}
		
		return null;
	}

	@Override
	public List<LeagueNode> searchLeagueNodes(final Long countryId) {
		return leagueNodeRepository.findByNodeCountryId(countryId);
	}

}
