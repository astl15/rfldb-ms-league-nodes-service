package com.astl.rfldb.leaguenodesservice.model.dto;

public class LeagueDTO {
	
	private Long leagueId;
	
	private String leagueName;
	
	private String leagueShortName;
	
	private String leagueNodeName;
	
	private Long regionId;
	
	public LeagueDTO() {}

	public Long getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(Long leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getLeagueShortName() {
		return leagueShortName;
	}

	public void setLeagueShortName(String leagueShortName) {
		this.leagueShortName = leagueShortName;
	}

	public String getLeagueNodeName() {
		return leagueNodeName;
	}

	public void setLeagueNodeName(String leagueNodeName) {
		this.leagueNodeName = leagueNodeName;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

}
