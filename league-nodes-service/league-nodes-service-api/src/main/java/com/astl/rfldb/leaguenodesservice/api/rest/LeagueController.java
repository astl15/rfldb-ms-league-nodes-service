package com.astl.rfldb.leaguenodesservice.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.astl.rfldb.leaguenodesservice.api.intf.LeagueService;
import com.astl.rfldb.leaguenodesservice.model.dto.LeagueDTO;
import com.astl.rfldb.leaguenodesservice.model.dto.SearchLeagueDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueIn;
import com.astl.rfldb.leaguenodesservice.model.in.SearchLeagueIn;

@RestController
@RequestMapping("/v1/leagues")
public class LeagueController {

	@Autowired
	private LeagueService leagueService;
	
	@RequestMapping(
			value = "/create",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE}, 
			method = RequestMethod.POST)
	public ResponseEntity<LeagueDTO> createLeague(@RequestBody final LeagueIn leagueIn) {
		LeagueDTO league = leagueService.createLeague(leagueIn);
		return new ResponseEntity<LeagueDTO>(league, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/search",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE}, 
			method = RequestMethod.POST)
	public ResponseEntity<SearchLeagueDTO> searchLeagues(final SearchLeagueIn searchLeagueIn) {
		SearchLeagueDTO response = leagueService.searchLeagues(searchLeagueIn);
		return new ResponseEntity<SearchLeagueDTO>(response, HttpStatus.OK);
	}
}
