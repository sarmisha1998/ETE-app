package com.orion.sports.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.orion.sports.model.Competition;

@Service
public class FAService {	
		
	public Competition gettingFACompetitions(String client) {	
	
	Map<Integer, String> compList  = new HashMap<>();	
			
	
	Competition faCompetitions = new Competition();
	if (client.equals("FA")) {

	compList.put(1, "THE FA CUP"); 
	compList.put(2,"THE WOMEN'S FA CUP"); 
	compList.put(3, "UEFA WOMEN'S EURO ENGLAND");
	compList.put(4, "National Premier League");				 			
	}else if (client.equals("AFL"))
	{
		compList.put(1, "AFL GRAND FINAL"); 
		compList.put(2,"AFL PREMIERSHIP"); 
		compList.put(3, "AFL TIPPING");
		compList.put(4, "AFLW");	
	}else if (client.equals("MLB"))
	{
		compList.put(1, "ALL STAR GAME"); 
		compList.put(2,"DIVISION SERIES"); 
		compList.put(3, "WILDCARD SERIES");
		compList.put(4, "WORLD SERIES");	
	}else if (client.equals("NHL"))
	{
		compList.put(1, "NHL ALL-STAR SKILLS COMPETITION"); 
		compList.put(2,"NHL GLOBAL SERIES"); 
		compList.put(3, "NHL STANLEY CUP");
		compList.put(4, "NHL CENTRE ICE");	
	}else
	{
		compList.put(1, "TELSTRAPREMIERSHIP"); 
		compList.put(2,"STATEOFORIGIN"); 
		compList.put(3, "NRLNINES");
		compList.put(4, "NSWRL");
		}
	
	
	
	
	if(!compList.isEmpty()) {
	
	faCompetitions.setCompetitions(compList);
	}
	return faCompetitions;

}
	
}
