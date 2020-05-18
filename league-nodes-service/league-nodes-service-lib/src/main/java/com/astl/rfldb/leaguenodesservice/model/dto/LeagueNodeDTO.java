package com.astl.rfldb.leaguenodesservice.model.dto;

import java.util.List;

public class LeagueNodeDTO {

	private Long nodeId;
	
	private String nodeName;
	
	private String commercialName;
	
	private Boolean isRegional;

	private Integer leaguesNumber;
	
	private List<String> leagueNames;
	
	public LeagueNodeDTO() {}

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

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

	public Integer getLeaguesNumber() {
		return leaguesNumber;
	}

	public void setLeaguesNumber(Integer leaguesNumber) {
		this.leaguesNumber = leaguesNumber;
	}

	public List<String> getLeagueNames() {
		return leagueNames;
	}

	public void setLeagueNames(List<String> leagueNames) {
		this.leagueNames = leagueNames;
	}
	
}
