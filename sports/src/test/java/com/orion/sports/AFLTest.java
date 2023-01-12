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
public class AFLTest {
	
	 @Autowired
	 public FAService faService;	 
	
	 
@Test
 public void getAFLCompList() throws Exception {
	
	 Competition aflCompTest = new Competition();
	 Competition aflCompTestActual = new Competition();
	 String client ="AFL";
	 
	 Map<Integer, String> aflCompList = new HashMap<Integer, String>();	
	 
	 aflCompList.put(1, "AFL GRAND FINAL"); 
	 aflCompList.put(2,"AFL PREMIERSHIP"); 
	 aflCompList.put(3, "FAIL");
	 aflCompList.put(4, "AFLW");
	 
	aflCompTest.setCompetitions(aflCompList);

	aflCompTestActual = faService.gettingFACompetitions(client);
		
 assertTrue(areEqual(aflCompTest.getCompetitions(), aflCompTestActual.getCompetitions()));
 
}


private boolean areEqual(Map<Integer, String> map, Map<Integer, String> map2) {
	if (map.size() != map2.size()) {
        return false;
    }

    return map.entrySet().stream()
      .allMatch(e -> e.getValue().equals(map2.get(e.getKey())));
}

}
