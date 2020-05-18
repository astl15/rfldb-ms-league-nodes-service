package com.astl.rfldb.leaguenodesservice.business.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LEAGUES")
public class League {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEAGUE_ID")
	private Long leagueId;
	
	@Column(name = "LEAGUE_NAME")
	private String leagueName;
	
	@Column(name = "LEAGUE_SHORT_NAME")
	private String leagueShortName;
	
	@Column(name = "LEAGUE_REGION_ID")
	private Long regionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEAGUE_NODE_ID")
	private LeagueNode leagueNode;

	public League() {}
	
	private League(Long leagueId, String leagueName, String leagueShortName, Long regionId, LeagueNode leagueNode) {
		super();
		this.leagueId = leagueId;
		this.leagueName = leagueName;
		this.leagueShortName = leagueShortName;
		this.regionId = regionId;
		this.leagueNode = leagueNode;
	}

	public Long getLeagueId() {
		return leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public String getLeagueShortName() {
		return leagueShortName;
	}

	public Long getRegionId() {
		return regionId;
	}

	public LeagueNode getLeagueNode() {
		return leagueNode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(leagueId, leagueName, leagueNode, leagueShortName, regionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		League other = (League) obj;
		return Objects.equals(leagueId, other.leagueId) && Objects.equals(leagueName, other.leagueName)
				&& Objects.equals(leagueNode, other.leagueNode)
				&& Objects.equals(leagueShortName, other.leagueShortName) && Objects.equals(regionId, other.regionId);
	}
	
	public static class LeagueBuilder {
		
		private Long leagueId;
		
		private String leagueName;
		
		private String leagueShortName;
		
		private Long regionId;
		
		private LeagueNode leagueNode;
		
		public LeagueBuilder addLeagueName(final String leagueName) {
			this.leagueName = leagueName;
			return this;
		}
		
		public LeagueBuilder addLeagueShortName(final String leagueShortName) {
			this.leagueShortName = leagueShortName;
			return this;
		}
		
		public LeagueBuilder addRegion(final Long regionId) {
			this.regionId = regionId;
			return this;
		}
		
		public LeagueBuilder addLeagueNode(final LeagueNode leagueNode) {
			this.leagueNode = leagueNode;
			return this;
		}
		
		public League build() {
			return new League(this.leagueId, this.leagueName, this.leagueShortName, this.regionId, this.leagueNode);
		}
		
	}
	
}
