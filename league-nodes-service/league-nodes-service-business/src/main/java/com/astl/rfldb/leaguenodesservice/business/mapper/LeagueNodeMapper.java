package com.astl.rfldb.leaguenodesservice.business.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.astl.rfldb.leaguenodesservice.business.entity.League;
import com.astl.rfldb.leaguenodesservice.business.entity.LeagueNode;
import com.astl.rfldb.leaguenodesservice.model.dto.LeagueNodeDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueNodeIn;

public class LeagueNodeMapper {

	public static LeagueNode mapFrom(final LeagueNodeIn leagueNodeIn) {
		return new LeagueNode.LeagueNodeBuilder()
				.addCommercialName(leagueNodeIn.getCommercialName())
				.addIsRegional(leagueNodeIn.getIsRegional())
				.addLeaguesNumber(leagueNodeIn.getLeaguesNumber())
				.build();
	}
	
	public static LeagueNodeDTO mapFrom(final LeagueNode leagueNode) {
		if(leagueNode != null) {
			LeagueNodeDTO output = new LeagueNodeDTO();
			output.setNodeId(leagueNode.getNodeId());
			output.setNodeName(leagueNode.getNodeName());
			output.setCommercialName(leagueNode.getCommercialName());
			output.setIsRegional(leagueNode.getIsRegional());
			output.setLeaguesNumber(leagueNode.getLeaguesNumber());

			if(leagueNode.getLeagues() != null && !leagueNode.getLeagues().isEmpty()) {
				List<String> leagueNames = new ArrayList<>();
				for(League league : leagueNode.getLeagues()) {
					leagueNames.add(league.getLeagueName());
				}
				
				output.setLeagueNames(leagueNames);
			}
			return output;
			
		}
		return null;
	}
	
	public static List<LeagueNodeDTO> mapFrom(final List<LeagueNode> input) {
		return Optional.ofNullable(input)
				.orElse(Collections.emptyList())
				.stream()
				.map(LeagueNodeMapper::mapFrom)
				.collect(Collectors.toList());
	}
	
}
