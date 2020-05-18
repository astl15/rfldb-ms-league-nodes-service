package com.astl.rfldb.leaguenodesservice.business.proxy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.cloud.openfeign.FeignClient;

import com.astl.rfldb.leaguenodesservice.business.proxy.dto.RegionDTO;
import com.astl.rfldb.leaguenodesservice.business.proxy.dto.CountryDTO;

@FeignClient(name = "${regionrepository.name}", url = "${regionrepository.endpoint}")
public interface RegionRepositoryServiceProxy {
	
	@GetMapping("/countries/search")
	public ResponseEntity<CountryDTO> findByCountryShortName(@RequestParam("shortName") final String countryShortName);
	
	@GetMapping("/search")
	public ResponseEntity<RegionDTO> findRegionByShortName(@RequestParam("shortName") final String regionShortName); 

}
