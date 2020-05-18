module leaguenodesservice.business {
	requires spring.beans;
	requires spring.context;
	requires spring.data.jpa;
	requires spring.data.commons;
	requires spring.tx;
	requires java.persistence;
	requires java.xml;
	requires spring.core;
	requires org.hibernate.orm.core;
	requires spring.cloud.openfeign.core;
	
	requires transitive leaguenodesservice.lib;
	requires spring.web;
	
	exports com.astl.rfldb.leaguenodesservice.business.manager to leaguenodesservice.api;
	exports com.astl.rfldb.leaguenodesservice.business.dao to spring.beans;
	exports com.astl.rfldb.leaguenodesservice.business.dao.utils;
	exports com.astl.rfldb.leaguenodesservice.business.entity to leaguenodesservice.api;
	exports com.astl.rfldb.leaguenodesservice.business.mapper to leaguenodesservice.api;
	exports com.astl.rfldb.leaguenodesservice.business.client to spring.beans;
	exports com.astl.rfldb.leaguenodesservice.business.proxy.dto;
	
	opens com.astl.rfldb.leaguenodesservice.business.manager;
	opens com.astl.rfldb.leaguenodesservice.business.dao;
	opens com.astl.rfldb.leaguenodesservice.business.entity;
	opens com.astl.rfldb.leaguenodesservice.business.client;
}