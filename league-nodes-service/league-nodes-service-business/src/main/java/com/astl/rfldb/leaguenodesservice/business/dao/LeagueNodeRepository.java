package com.astl.rfldb.leaguenodesservice.business.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astl.rfldb.leaguenodesservice.business.entity.LeagueNode;

@Repository
public interface LeagueNodeRepository extends JpaRepository<LeagueNode,Long> {
	
	LeagueNode findByNodeName(final String nodeName);

	List<LeagueNode> findByNodeCountryId(final Long nodeCountryId);
	
}
