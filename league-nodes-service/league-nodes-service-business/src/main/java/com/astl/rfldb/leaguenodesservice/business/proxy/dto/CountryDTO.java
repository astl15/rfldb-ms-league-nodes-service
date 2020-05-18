package com.astl.rfldb.leaguenodesservice.business.proxy.dto;

public class CountryDTO {
	private Long countryId;
	
	private String countryName;
	
	private String countryShortName;

	public CountryDTO() {}

	public CountryDTO(Long countryId, String countryName, String countryShortName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryShortName = countryShortName;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryShortName() {
		return countryShortName;
	}

	public void setCountryShortName(String countryShortName) {
		this.countryShortName = countryShortName;
	}
	
}
