package com.astl.rfldb.leaguenodesservice.model.in;

public class LeagueNodeIn {
	
	private String commercialName;
	
	private Boolean isRegional;
	
	private String regionShortName;
	
	private String countryShortName;
	
	private Integer leaguesNumber;

	public LeagueNodeIn() {}

	public String getCommercialName() {
		return commercialName;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}

	public Boolean getIsRegional() {
		return isRegional;
	}

	public void setIsRegional(Boolean isRegional) {
		this.isRegional = isRegional;
	}

	public String getRegionShortName() {
		return regionShortName;
	}

	public void setRegionShortName(String regionShortName) {
		this.regionShortName = regionShortName;
	}

	public String getCountryShortName() {
		return countryShortName;
	}

	public void setCountryShortName(String countryShortName) {
		this.countryShortName = countryShortName;
	}

	public Integer getLeaguesNumber() {
		return leaguesNumber;
	}

	public void setLeaguesNumber(Integer leaguesNumber) {
		this.leaguesNumber = leaguesNumber;
	}

}
