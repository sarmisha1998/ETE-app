package com.orion.sports;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.orion.sports.model.Competition;
import com.orion.sports.service.FAService;

@SpringBootTest
@AutoConfigureMockMvc
public class NHLTest {
	
	 @Autowired
	 public FAService faService;	
	 
@Test
 public void getFACompList() throws Exception {
	
	 Competition mlbCompTest = new Competition();
	 Competition mlbCompTestActual = new Competition();
	 String client ="NHL";
	 
	Map<Integer, String> mlbCompList = new HashMap<Integer, String>();	
	 
	 mlbCompList.put(1, "NHL ALL-STAR SKILLS COMPETITION"); 
	 mlbCompList.put(2,"NHL GLOBAL SERIES"); 
	 mlbCompList.put(3, "NHL STANLEY CUP");
	 mlbCompList.put(4, "NHL CENTRE ICE");
	 
	mlbCompTest.setCompetitions(mlbCompList);

 mlbCompTestActual = faService.gettingFACompetitions(client);
		
 assertTrue(areEqual(mlbCompTest.getCompetitions(), mlbCompTestActual.getCompetitions()));
 
}


private boolean areEqual(Map<Integer, String> map, Map<Integer, String> map2) {
	if (map.size() != map2.size()) {
        return false;
    }

    return map.entrySet().stream()
      .allMatch(e -> e.getValue().equals(map2.get(e.getKey())));
}

}
