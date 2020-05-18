package com.astl.rfldb.leaguenodesservice.business.mapper;

import com.astl.rfldb.leaguenodesservice.business.dao.utils.LeagueProjection;
import com.astl.rfldb.leaguenodesservice.business.entity.League;
import com.astl.rfldb.leaguenodesservice.business.entity.LeagueNode;
import com.astl.rfldb.leaguenodesservice.model.dto.LeagueDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueIn;

public class LeagueMapper {
	
	public static League mapFrom(final LeagueIn leagueIn) {
		
		LeagueNode leagueNode = new LeagueNode.LeagueNodeBuilder()
				.addNodeName(leagueIn.getLeagueNodeName())
				.build();
		
		return new League.LeagueBuilder()
				.addLeagueName(leagueIn.getLeagueName())
				.addLeagueShortName(leagueIn.getLeagueShortName())
				.addLeagueNode(leagueNode)
				.build();
	}
	
	public static LeagueDTO mapFrom(final League league) {
		if(league != null) {
			LeagueDTO output = new LeagueDTO();
			output.setLeagueId(league.getLeagueId());
			output.setLeagueName(league.getLeagueName());
			output.setLeagueShortName(league.getLeagueShortName());
			
			if(league.getLeagueNode() != null) {
				output.setLeagueNodeName(league.getLeagueNode().getNodeName());
			}

			output.setRegionId(league.getRegionId());

			return output;
		}
		
		return null;
	}
	
	public static LeagueDTO mapFrom(LeagueProjection projection) {
		if(projection != null) {
			LeagueDTO output = new LeagueDTO();
			output.setLeagueId(projection.getLeagueId());
			output.setLeagueName(projection.getLeagueName());
			output.setLeagueShortName(projection.getLeagueShortName());
			return output;
		}
		return null;
	}

}
