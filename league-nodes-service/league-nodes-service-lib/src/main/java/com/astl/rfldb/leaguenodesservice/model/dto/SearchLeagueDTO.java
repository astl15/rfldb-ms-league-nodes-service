package com.astl.rfldb.leaguenodesservice.model.dto;

import java.util.List;

public class SearchLeagueDTO {
	
	private int totalElements;
	
	List<LeagueDTO> leagues;

	public SearchLeagueDTO() {}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public List<LeagueDTO> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<LeagueDTO> leagues) {
		this.leagues = leagues;
	}
	
}
