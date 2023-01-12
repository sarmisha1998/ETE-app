package Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
//import pageFactory.LoginPage;

public class BaseClass {
	public static WebDriver driver = null;
	public static Faker faker;
	public WebDriverWait wait;
	public Actions Action;

	@BeforeTest
	public void init() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		Scanner myObj = new Scanner(System.in);
//		System.out.println("Enter Browser Name: (eg. FireFox, Chrome, Edge)");
//		String name = myObj.nextLine();
//		if (name.equalsIgnoreCase("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (name.equalsIgnoreCase("FireFox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else if (name.equalsIgnoreCase("Edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		} else {
//			System.out.println("Invalid Browser : Enter Browser Name: eg. (Firefox, Edge, Chrome)");
//		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void takeScreenShotOnFailures(ITestResult testResult) throws IOException, InterruptedException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
			ExtentTestManager.getTest().log(Status.INFO,
					"Attached screenshot of failed test " + testResult.getMethod().getMethodName(),
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			File destination = new File(path);
			try {
				FileUtils.copyFile(scr, destination);

//				LoginPage loginPage = new LoginPage(driver);
//				loginPage.logout();
			} catch (IOException e) {
				System.out.println("Capture Failed " + e.getMessage());
			}

			return;
		}

//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.logout();
//		close

	}

	@AfterTest
	public void tearDown() throws InterruptedException {
	driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void pageDown() throws AWTException {
		for (int i = 0; i < 50; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}

	}

	public static void pageUp() throws AWTException {
		for (int i = 0; i < 50; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
		}

	}

	public static void vk_home() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_HOME);
		robot.keyRelease(KeyEvent.VK_HOME);


}

	public static void vk_end() throws AWTException {

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);


	}

	public static void close() {
		driver.close();
	}

	public static void fakerFirstName() {
		faker = new Faker();
		faker.name().firstName();
	}

	// getAttribute
	public static String getAriaCheckedAttribute(WebElement element) {
		String attribute = element.getAttribute("aria-checked");
		System.out.println(attribute);
		return attribute;
	}

	// getAttribute
	public static String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
//        System.out.println(attribute);
		return attribute;
	}

	public static String getCssValue(WebElement element) {
		String cssValue = element.getAttribute("stroke");
//        System.out.println(attribute);
		return cssValue;
	}

	public static String getSrcAttribute(WebElement element) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, 100);
			wt.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}
		String attribute = element.getAttribute("src");
		return attribute;

//        System.out.println(attribute);

	}

	public static String getStyleAttribute(WebElement element) {
		String attribute = element.getAttribute("style");
//        System.out.println(attribute);
		return attribute;
	}

	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException, InterruptedException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
			ExtentTestManager.getTest().log(Status.INFO,
					"Attached screenshot of failed test " + testResult.getMethod().getMethodName(),
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			File destination = new File(path);
			try {
				FileUtils.copyFile(scr, destination);
//				LoginPage loginPage = new LoginPage(driver);
//				loginPage.logout();
			} catch (IOException e) {
				System.out.println("Capture Failed " + e.getMessage());
			}

			return;
		}

	}
public void Alert() {
	Alert alert = driver.switchTo().alert();
	alert.sendKeys("abcd");

}




	public void wait_statement(WebElement element) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, 100);
			wt.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void wait_statement_Invisible(WebElement element) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, 100);
			wt.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void wait_visibilityOf(WebElement element) {
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(element));
	}

	public void wait_statementListElement(List<WebElement> element) {
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void select_dropdown(List<WebElement> val, String Val) {
		for (WebElement ele : val) {
			String Select_val = ele.getText();
			if (Select_val.contains(Val)) {
				ele.click();
				break;
			}
		}
	}

	public boolean FindByisDisplayed(WebElement xpath) {
		boolean flag;
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			flag = xpath.isDisplayed();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public static void clearElement(WebElement element) {
		element.clear();
	}

	public void FindByclick(WebElement select) {
		wait_statement(select);
		if (select.isDisplayed() && select.isEnabled()) {
			wait = new WebDriverWait(driver, 30);
			wait_statement(select);
			wait.until(ExpectedConditions.elementToBeClickable(select));
			select.click();

		} else {
			wait = new WebDriverWait(driver, 30);
			wait_statement(select);
			wait.until(ExpectedConditions.elementToBeClickable(select));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", select);
		}
	}

	public boolean FindByElementappear(WebElement xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(xpath));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean FindByElementdisappear(WebElement xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOf(xpath));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public void MouseClickToElement(WebElement element) {
		Action = new Actions(driver);
		try {
			Action.moveToElement(element).click(element).build().perform();
		} catch (Exception e) {
		}
	}

	public void FindByMoveToElements(WebElement xpath) {
		Action = new Actions(driver);
		try {
			Action.moveToElement(xpath).build().perform();
		} catch (Exception e) {
		}
	}

	public boolean FindByElementClickable(WebElement xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(xpath));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean FindBytypeIn(WebElement Send, String data) {
		boolean flag;

		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(Send));
			Send.clear();
			safeJavaScriptClear(Send);

			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(Send));
			Send.sendKeys(data);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public void FindByDoubleClickToElement(WebElement xpath) {
		Action = new Actions(driver);
		try {
			Action.doubleClick(xpath).build().perform();
		} catch (Exception e) {
		}
	}

	public static void safeJavaScriptClear(WebElement element) throws Exception {

		if (element.isEnabled() && element.isDisplayed()) {
//			System.out.println("Clicking on element with using java script clear");

			((JavascriptExecutor) driver).executeScript("arguments[0].value ='';", element);
		} else {
			System.out.println("Unable to clear on element");
		}
	}

	public void FidnByMoveToElement(WebElement element) {
		Action = new Actions(driver);
		try {
			Action.moveToElement(element).build().perform();
		} catch (Exception e) {
		}
	}

	// getText
	public static String getTexts(WebElement element) {

		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(element));
		String text = element.getText();
		return text;
	}

	public String getText(WebElement xpath) {
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(xpath));
		String elementvalue = null;
		try {
			String textvalue = xpath.getText();
			elementvalue = textvalue;
		} catch (Exception e) {

		}
		return elementvalue;

	}

	public void verification(boolean value, String informationdetails, String failinformation) {
		if (value) {
			ExtentTestManager.getTest().log(Status.PASS, informationdetails);
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, failinformation);
		}
	}

	public WebDriver newwindow() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public String Currentdate() {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		String current = date.format(d);
		return current;

	}

	public String CurrentdateforEmailformat() {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy");
		String current = date.format(d);
		return current;

	}

	public String futureDateFormat(int noofdaysincount) throws ParseException {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy");
		String current = date.format(d);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date.parse(current));
		calendar.add(Calendar.DAY_OF_YEAR, noofdaysincount);
		String futuredate = date.format(calendar.getTime());
		return futuredate;
	}

	// applaunch
	public static void applaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	// getTitle
	public static String getTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return title;
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click on Element
	public static void click(WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			click(element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// waitforvisibilityofelement
	public static void waitforvisibilityofelement(WebElement element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 30);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void waitforvisibilityofelements(List<WebElement> element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 30);
			wb.until(ExpectedConditions.visibilityOfAllElements((WebElement) element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrollToEndPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public static void back() throws InterruptedException {

		driver.navigate().back();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	// inputonelement
	public static String input(WebElement element, String value) throws Exception {
		safeJavaScriptClear(element);
		element.sendKeys(value);
		return value;

	}

	// scrollingup
	public static void scrollingup(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollingDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(element));
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	// doubleclick
	public static void doubleclick(WebElement element) {
		Actions ac2 = new Actions(driver);
		ac2.doubleClick(element).build().perform();
	}

	// keypressDown
	public static void keypressEscape() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public static void downloadTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void safeJavaScriptClick(WebElement element) throws Exception {

		if (element.isEnabled() && element.isDisplayed()) {
			System.out.println("Clicking on element with using java script click");

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} else {
			System.out.println("Unable to click on element");
		}
	}

	// keypressDown
	public static void escape() throws InterruptedException, AWTException {
		for (int i = 0; i < 5; i++) {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);

		}

	}
}
