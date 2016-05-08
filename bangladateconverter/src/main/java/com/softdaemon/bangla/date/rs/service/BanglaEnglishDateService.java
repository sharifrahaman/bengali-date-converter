package com.softdaemon.bangla.date.rs.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.softdaemon.bangla.date.converter.BanglaDateUtils;
import com.softdaemon.bangla.date.converter.BanglaMonth;
import com.softdaemon.bangla.date.converter.Date;
import com.softdaemon.bangla.date.converter.EnglishMonth;

/**
 * RESTful service to expose the Bengali date converter
 * @author sharif
 *
 */

@Path("/to")
public class BanglaEnglishDateService {

	@GET
	@Path("/bengali/{year}/{month}/{day}")
	@Produces(MediaType.APPLICATION_JSON)
	public Date<BanglaMonth> getBanglaDate(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day) {		
 
		return BanglaDateUtils.getBanglaDate(year, month, day);
	}
	
	@GET
	@Path("/english/{year}/{month}/{day}")
	@Produces(MediaType.APPLICATION_JSON)
	public Date<EnglishMonth> getEnglishDate(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day) {
 		
		return BanglaDateUtils.getEnglishDate(year, month, day);
 
	}
}
