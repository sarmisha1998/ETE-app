package moduleScript;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Base.ExcelUtility;
import pageFactory.LoginPage;
//import pageFactory.LoginPage;

public class Launch extends BaseClass {

	@Test(dataProvider = "getdata", enabled = true, priority = 1)
	public void AppLaunch(HashMap<String, String> ETE) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ETE);
		Assert.assertEquals("WELCOME TO ORION SPORTS", loginPage.welcome().trim());
		
	}

	
	
	
	@DataProvider(name = "getdata")
	public static Object[][] gettestdata(Method m) throws Exception {
		String data;
		String testname;
		data = "/root/.jenkins/workspace/end-end-cicd/FunctionalTest/files/demotest.xlsx";
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
