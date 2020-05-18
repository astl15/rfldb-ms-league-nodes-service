package com.astl.rfldb.leaguenodesservice.business.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.astl.rfldb.leaguenodesservice.business.proxy.RegionRepositoryServiceProxy;
import com.astl.rfldb.leaguenodesservice.business.proxy.dto.CountryDTO;
import com.astl.rfldb.leaguenodesservice.business.proxy.dto.RegionDTO;

@Component
public class RegionRepositoryClient {

	@Autowired
	private RegionRepositoryServiceProxy service;
	
	public RegionRepositoryClient() {}
	
	public CountryDTO getCountry(final String countryShortName) {
		if(service != null) {
			return service.findByCountryShortName(countryShortName).getBody();
		}
		return null;
	}
	
	public RegionDTO getRegion(final String regionShortName) {
		if(service != null) {
			return service.findRegionByShortName(regionShortName).getBody();
		}
		return null;
	}
}
