package com.astl.rfldb.leaguenodesservice.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.astl.rfldb.leaguenodesservice.api.intf.LeagueNodeService;
import com.astl.rfldb.leaguenodesservice.business.manager.LeagueNodeManager;
import com.astl.rfldb.leaguenodesservice.business.mapper.LeagueNodeMapper;
import com.astl.rfldb.leaguenodesservice.model.dto.LeagueNodeDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueNodeIn;
import com.astl.rfldb.leaguenodesservice.model.in.SearchLeagueNodeIn;

@Component
public class LeagueNodeServiceImpl implements LeagueNodeService {

	@Autowired
	private LeagueNodeManager leagueNodeManager; 
	
	@Override
	public LeagueNodeDTO createLeagueNode(final LeagueNodeIn leagueNodeIn) {
		return LeagueNodeMapper.mapFrom(leagueNodeManager.createLeagueNode(leagueNodeIn));
	}

	@Override
	public List<LeagueNodeDTO> searchLeagueNodes(SearchLeagueNodeIn searchLeagueNodeIn) {
		return LeagueNodeMapper.mapFrom(leagueNodeManager.searchLeagueNodes(searchLeagueNodeIn));
	}

}
