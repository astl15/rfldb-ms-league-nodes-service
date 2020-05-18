package com.astl.rfldb.leaguenodesservice.business.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.astl.rfldb.leaguenodesservice.business.client.RegionRepositoryClient;
import com.astl.rfldb.leaguenodesservice.business.dao.LeagueDAO;
import com.astl.rfldb.leaguenodesservice.business.dao.utils.LeagueProjection;
import com.astl.rfldb.leaguenodesservice.business.entity.League;
import com.astl.rfldb.leaguenodesservice.business.entity.LeagueNode;
import com.astl.rfldb.leaguenodesservice.business.proxy.dto.RegionDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueIn;
import com.astl.rfldb.leaguenodesservice.model.in.SearchLeagueIn;

@Component
public class LeagueManager {
	@Autowired
	private LeagueDAO leagueDao;
	
	@Autowired
	private LeagueNodeManager leagueNodeManager;
	
	@Autowired
	private RegionRepositoryClient regionRepositoryClient;
	
	public League createLeague(final LeagueIn leagueIn) {
		if(leagueIn != null) {
			LeagueNode leagueNode = leagueNodeManager
					.findLeagueNodeByNodeName(leagueIn.getLeagueNodeName());
			
			if(leagueNode != null) {
				Long regionId = null;
				if(leagueNode.getIsRegional()) {
					RegionDTO region = regionRepositoryClient.getRegion(leagueIn.getLeagueRegionShortName());
					if(region != null) {
						regionId = region.getRegionId();
					}
				}
				
				League league = new League.LeagueBuilder()
						.addLeagueName(leagueIn.getLeagueName())
						.addLeagueShortName(leagueIn.getLeagueShortName())
						.addLeagueNode(leagueNode)
						.addRegion(regionId)
						.build();
				
				return leagueDao.createLeague(league);
			}
		}
		
		return null;
	}
	
	public League findLeaguebyLeagueName(final String leagueName) {
		return leagueDao.findLeagueByLeagueName(leagueName);
	}
	
	public Page<LeagueProjection> searchLeagues(final SearchLeagueIn searchLeagueIn) {
		if(searchLeagueIn != null) {
			Pageable pageable = PageRequest
					.of(searchLeagueIn.getPageNumber(), searchLeagueIn.getNrOfResultsPerPage());
			return leagueDao.findPagedProjectedBy(pageable);
		}
		return null;
	}


}
