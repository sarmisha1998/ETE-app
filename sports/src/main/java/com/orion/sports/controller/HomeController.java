package com.orion.sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orion.sports.model.Competition;
import com.orion.sports.service.FAService;

@RestController
public class HomeController {
	
	  @Autowired
	    private FAService faservice;

		@GetMapping("/gettingCompetitions")
		public ResponseEntity<Competition> getCompetitionList(@RequestParam(name="client", required=true)String name) {
			
			Competition faCompetitions;				
			faCompetitions	=	faservice.gettingFACompetitions(name);			
			return new ResponseEntity<>(faCompetitions,HttpStatus.OK);	
			}	
		
		

}
