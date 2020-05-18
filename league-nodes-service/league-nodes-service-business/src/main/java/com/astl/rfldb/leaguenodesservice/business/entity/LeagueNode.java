package com.astl.rfldb.leaguenodesservice.business.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LEAGUE_NODES")
public class LeagueNode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEAGUE_NODE_ID")
	private Long nodeId;
	
	@Column(name = "LEAGUE_NODE_NAME")
	private String nodeName;
	
	@Column(name = "LEAGUE_NODE_COMM_NAME")
	private String commercialName;
	
	@Column(name = "LEAGUE_NODE_IS_REGIONAL")
	private Boolean isRegional;
	
	@Column(name = "LEAGUE_NODE_LEAGUES_NR")
	private Integer leaguesNumber;
	
	@Column(name = "LEAGUE_NODE_COUNTRY_ID")
	private Long nodeCountryId;
	
	@OneToMany(mappedBy = "leagueNode", 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<League> leagues;

	public LeagueNode() {}

	private LeagueNode(Long nodeId, String nodeName, String commercialName, Boolean isRegional, Integer leaguesNumber,
			Long nodeCountryId, List<League> leagues) {
		super();
		this.nodeId = nodeId;
		this.nodeName = nodeName;
		this.commercialName = commercialName;
		this.isRegional = isRegional;
		this.leaguesNumber = leaguesNumber;
		this.nodeCountryId = nodeCountryId;
		this.leagues = leagues;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public String getCommercialName() {
		return commercialName;
	}

	public Boolean getIsRegional() {
		return isRegional;
	}

	public Integer getLeaguesNumber() {
		return leaguesNumber;
	}

	public Long getNodeCountryId() {
		return nodeCountryId;
	}

	public List<League> getLeagues() {
		return leagues;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commercialName, isRegional, leaguesNumber, nodeCountryId, nodeId, nodeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeagueNode other = (LeagueNode) obj;
		return Objects.equals(commercialName, other.commercialName) && Objects.equals(isRegional, other.isRegional)
				&& Objects.equals(leaguesNumber, other.leaguesNumber)
				&& Objects.equals(nodeCountryId, other.nodeCountryId) && Objects.equals(nodeId, other.nodeId)
				&& Objects.equals(nodeName, other.nodeName);
	}
	
	public static class LeagueNodeBuilder {
		
		private Long nodeId;
		
		private String nodeName;
		
		private String commercialName;
		
		private Boolean isRegional;
		
		private Integer leaguesNumber;
		
		private Long nodeCountryId;		
		
		private List<League> leagues;
		
		public LeagueNodeBuilder addNodeId(final Long nodeId) {
			this.nodeId = nodeId;
			return this;
		}
		
		public LeagueNodeBuilder addNodeName(final String nodeName) {
			this.nodeName = nodeName;
			return this;
		}
		
		public LeagueNodeBuilder addCommercialName(final String commercialName) {
			this.commercialName = commercialName;
			return this;
		}
		
		public LeagueNodeBuilder addIsRegional(final Boolean isRegional) {
			this.isRegional = isRegional;
			return this;
		}
		
		public LeagueNodeBuilder addLeaguesNumber(final Integer leaguesNumber) {
			this.leaguesNumber = leaguesNumber;
			return this;
		}
		
		public LeagueNodeBuilder addNodeCountryId(final Long nodeCountryId) {
			this.nodeCountryId = nodeCountryId;
			return this;
		}
		
		public LeagueNodeBuilder addLeagues(final List<League> leagues) {
			this.leagues = leagues;
			return this;
		}
		
		public LeagueNode build() {
			return new LeagueNode(this.nodeId, this.nodeName, this.commercialName, 
					this.isRegional, this.leaguesNumber, this.nodeCountryId, this.leagues);
		}
		
	}
}
