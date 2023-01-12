package moduleScript;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Base.ExcelUtility;
import pageFactory.LoginPage;
//import pageFactory.LoginPage;

public class Modules extends BaseClass {

	@Test(dataProvider = "getdata", enabled = true, priority = 1)
	public void FA(HashMap<String, String> ETE) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ETE);
		String fa = loginPage.FAclick();
		boolean contains = fa.contains("faCompetition");
		Assert.assertEquals(contains, true);
	}

	@Test(dataProvider = "getdata", enabled = true, priority = 2)
	public void AFL(HashMap<String, String> ETE) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ETE);
		String afl = loginPage.AFL();
		boolean contains = afl.contains("aflCompetition");
		Assert.assertEquals(contains, true);
	}

	
	@Test(dataProvider = "getdata", enabled = true, priority = 3)
	public void MLB(HashMap<String, String> ETE) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ETE);
		String mlb = loginPage.MLB();
		boolean contains = mlb.contains("mlbCompetition");
		Assert.assertEquals(contains, true);
	}
	
	@Test(dataProvider = "getdata", enabled = true, priority = 4)
	public void NRL(HashMap<String, String> ETE) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ETE);
		String nrl = loginPage.NRL();
		boolean contains = nrl.contains("nrlCompetition");
		Assert.assertEquals(contains, true);
	}
	
	@Test(dataProvider = "getdata", enabled = true, priority = 5)
	public void NHL(HashMap<String, String> ETE) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ETE);
		String nhl = loginPage.NHL();
		boolean contains = nhl.contains("nhlCompetition");
		Assert.assertEquals(contains, true);
	}
	
	@Test(dataProvider = "getdata", enabled = true, priority = 6)
	public void HKJC(HashMap<String, String> ETE) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ETE);
		String hkjc = loginPage.HKJC();
		boolean contains = hkjc.contains("hkjcCompetition");
		Assert.assertEquals(contains, true);
	}
	


	
	@DataProvider(name = "getdata")
	public static Object[][] gettestdata(Method m) throws Exception {
		String data;
		String testname;
		data = "C:\\Windows\\ServiceProfiles\\LocalService\\.jenkins\\workspace\\demo\\files\\demotest.xlsx";
		testname = m.getName();
		System.out.println(testname);
		Object[][] testdata = ExcelUtility.getvalues(data, "Test", testname);
		HashMap<String, String> att_map = null;
		Object[][] testdataoutput = new Object[testdata.length - 1][1];
		for (int i = 1; i < testdata.length; i++) {
			att_map = new HashMap<>();
			for (int j = 0; j < testdata[i].length; j++) {
				if (testdata[i][j] == null) {
					att_map.put(testdata[0][j].toString(), "");
				} else {
					att_map.put(testdata[0][j].toString(), testdata[i][j].toString());
				}
			}
			testdataoutput[i - 1][0] = att_map;
			att_map = null;
		}
		return testdataoutput;
	}
	
	
}
