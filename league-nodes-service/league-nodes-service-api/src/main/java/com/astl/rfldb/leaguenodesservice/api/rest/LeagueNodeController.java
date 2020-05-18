package com.astl.rfldb.leaguenodesservice.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.astl.rfldb.leaguenodesservice.api.intf.LeagueNodeService;
import com.astl.rfldb.leaguenodesservice.model.dto.LeagueNodeDTO;
import com.astl.rfldb.leaguenodesservice.model.in.LeagueNodeIn;
import com.astl.rfldb.leaguenodesservice.model.in.SearchLeagueNodeIn;

@RestController
@RequestMapping("/v1/leaguenodes")
public class LeagueNodeController {
	
	@Autowired
	private LeagueNodeService leagueNodeService;

	@RequestMapping(
			value = "/create",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE}, 
			method = RequestMethod.POST)
	public ResponseEntity<LeagueNodeDTO> createLeagueNode(@RequestBody LeagueNodeIn leagueNodeIn) {
		LeagueNodeDTO leagueNode = leagueNodeService.createLeagueNode(leagueNodeIn);
		return new ResponseEntity<LeagueNodeDTO>(leagueNode, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/search",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE}, 
			method = RequestMethod.POST)
	public ResponseEntity<List<LeagueNodeDTO>> searchLeagueNodes(@RequestBody SearchLeagueNodeIn searchLeagueNodeIn) {
		List<LeagueNodeDTO> leagueNodes = leagueNodeService.searchLeagueNodes(searchLeagueNodeIn);
		return new ResponseEntity<List<LeagueNodeDTO>>(leagueNodes, HttpStatus.OK);
	}
	
	
}
