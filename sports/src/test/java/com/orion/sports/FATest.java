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
public class FATest {
	
	 @Autowired
	 public FAService faService;

	 
@Test
 public void getFACompList() throws Exception {
	
	 Competition faCompTest = new Competition();
	 Competition faCompTestActual = new Competition();
	 String client = "FA";
	 
	 Map<Integer, String> faCompList = new HashMap<Integer, String>();	
	 
	 faCompList.put(1, "THE FA CUP"); 
	 faCompList.put(2,"THE WOMEN'S FA CUP"); 
	 faCompList.put(3, "UEFA WOMEN'S EURO ENGLAND");
	 faCompList.put(4, "National Premier League");
	 
	faCompTest.setCompetitions(faCompList);

 faCompTestActual = faService.gettingFACompetitions(client);
		
 assertTrue(areEqual(faCompTest.getCompetitions(), faCompTestActual.getCompetitions()));
 
}


private boolean areEqual(Map<Integer, String> map, Map<Integer, String> map2) {
	if (map.size() != map2.size()) {
        return false;
    }

    return map.entrySet().stream()
      .allMatch(e -> e.getValue().equals(map2.get(e.getKey())));
}

}
