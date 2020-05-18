package com.astl.rfldb.leaguenodesservice.model.in;

public class SearchLeagueIn {

	private String countryShortName;
	
	private String leagueName;
	
	private int pageNumber;
	
	private int nrOfResultsPerPage;

	public SearchLeagueIn() {}

	public String getCountryShortName() {
		return countryShortName;
	}

	public void setCountryShortName(String countryShortName) {
		this.countryShortName = countryShortName;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getNrOfResultsPerPage() {
		return nrOfResultsPerPage;
	}

	public void setNrOfResultsPerPage(int nrOfResultsPerPage) {
		this.nrOfResultsPerPage = nrOfResultsPerPage;
	}
	
}
