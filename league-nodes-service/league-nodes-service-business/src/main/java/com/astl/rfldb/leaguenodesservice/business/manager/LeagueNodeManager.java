package com.astl.rfldb.leaguenodesservice.business.manager;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.astl.rfldb.leaguenodesservice.business.client.RegionRepositoryClient;
import com.astl.rfldb.leaguenodesservice.business.dao.LeagueNodeDAO;
import com.astl.rfldb.leaguenodesservice.business.entity.LeagueNode;
import com.astl.rfldb.leaguenodesservice.business.proxy.dto.CountryDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueNodeIn;
import com.astl.rfldb.leaguenodesservice.model.in.SearchLeagueNodeIn;

@Component
public class LeagueNodeManager {

	@Autowired
	private LeagueNodeDAO leagueNodeDao;
	
	@Autowired
	private RegionRepositoryClient regionRepositoryClient;
	
	public LeagueNode createLeagueNode(final LeagueNodeIn leagueNodeIn) {
		if(leagueNodeIn != null && leagueNodeIn.getCountryShortName() != null) {
			Optional<CountryDTO> serviceResult = Optional.ofNullable(
					regionRepositoryClient.getCountry(leagueNodeIn.getCountryShortName()));
			
			
			if(serviceResult.isPresent()) {
				CountryDTO country = serviceResult.get();
				Long leagueNodeIndex = leagueNodeDao.getCountryLastLeagueNodeIndex(country.getCountryId());
				
				if(leagueNodeIndex == null) {
					leagueNodeIndex = 1L;
				}else {
					leagueNodeIndex++; 
				}
				
				LeagueNode leagueNode = new LeagueNode.LeagueNodeBuilder()
						.addNodeName(country.getCountryShortName() + leagueNodeIndex)
						.addCommercialName(leagueNodeIn.getCommercialName())
						.addIsRegional(leagueNodeIn.getIsRegional())
						.addLeaguesNumber(leagueNodeIn.getLeaguesNumber())
						.addNodeCountryId(country.getCountryId())
						.build();
				return leagueNodeDao.createLeagueNode(leagueNode);
			}
		}
		
		return null;
	}
	
	public LeagueNode findLeagueNodeByNodeName(final String nodeName) {
		return leagueNodeDao.findLeagueNodeByNodeName(nodeName);
	}
	
	public List<LeagueNode> searchLeagueNodes(final SearchLeagueNodeIn searchLeagueNodeIn) {
		if(searchLeagueNodeIn != null && searchLeagueNodeIn.getCountryShortName() != null) {
			Optional<CountryDTO> serviceResult = Optional.ofNullable(
					regionRepositoryClient.getCountry(searchLeagueNodeIn.getCountryShortName()));
			
			if(serviceResult.isPresent()) {
				CountryDTO country = serviceResult.get();
				return leagueNodeDao.searchLeagueNodes(country.getCountryId());
			}
		}
		return Collections.emptyList();
		
	}
}
