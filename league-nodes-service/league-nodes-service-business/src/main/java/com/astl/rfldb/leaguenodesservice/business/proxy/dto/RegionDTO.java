package com.astl.rfldb.leaguenodesservice.business.proxy.dto;

public class RegionDTO {
	
	private Long regionId;
	
	private String regionName;
	
	private String regionShortName;
	
	private String countryShortName;

	public RegionDTO(Long regionId, String regionName, String regionShortName, String countryShortName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
		this.regionShortName = regionShortName;
		this.countryShortName = countryShortName;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
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

}
