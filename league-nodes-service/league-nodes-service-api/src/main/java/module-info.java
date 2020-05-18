open module leaguenodesservice.api {
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires java.instrument;
	requires java.sql;
	
	requires leaguenodesservice.business;
	requires leaguenodesservice.lib;
	requires spring.context;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires spring.cloud.openfeign.core;
}