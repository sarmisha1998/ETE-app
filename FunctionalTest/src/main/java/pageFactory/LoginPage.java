package pageFactory;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class LoginPage extends BaseClass {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void login(HashMap<String, String> loginDetails) throws InterruptedException, IOException, AWTException {
		applaunch(loginDetails.get("URL"));
	}
	
	public String welcome(){
		WebElement text = driver.findElement(By.xpath("//div[@class='leftcolumn']//p"));
		String welcome = getText(text);
		return welcome;
	}
	
	public String FAclick() {
		driver.findElement(By.xpath("//*[@alt='FootBall Association']/..")).click();
		String fa = driver.getCurrentUrl();
		return fa;
	}
	
	public String AFL() {
		driver.findElement(By.xpath("//*[@alt='Australian Football League']/..")).click();
		String afl = driver.getCurrentUrl();
		return afl;
	}
	
	public String MLB() {
		driver.findElement(By.xpath("//*[@alt='Major League Baseball']/..")).click();
		String mlb = driver.getCurrentUrl();
		return mlb;
	}
	
	public String NRL() {
		driver.findElement(By.xpath("//*[@alt='National Rugby League']/..")).click();
		String nrl = driver.getCurrentUrl();
		return nrl;
	}
	
	public String NHL() {
		driver.findElement(By.xpath("//*[@alt='National Hockey League']/..")).click();
		String nhl = driver.getCurrentUrl();
		return nhl;
	}
	
	public String HKJC() {
		driver.findElement(By.xpath("//*[@alt='Hong Kong Jockey Club']/..")).click();
		String hkjc = driver.getCurrentUrl();
		return hkjc;
	}
	
}
