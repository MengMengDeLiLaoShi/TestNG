package button;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.firefox.FirefoxProfile;

public class AlterTest {
//	ProfilesIni profileini = new ProfilesIni();
//	FirefoxProfile profile = profileini.getProfile("default");
	WebDriver driver = new FirefoxDriver();//profile
	
	@Before
	public void setup(){
		driver.get("file:///d:/Alert.html");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void AlterTes(){
//		WebElement username = driver.findElement(By.xpath("//input[@name=\"account\"]"));
//		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
//		WebElement submit = driver.findElement(By.xpath("//button[@data-loading=\"ит╨Р...\"]"));
//
//		username.sendKeys("liujiang1");
//		password.sendKeys("1");
//		submit.submit();
		WebElement alert = driver.findElement(By.xpath("//input[1]"));
		alert.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void confirm(){
		WebElement alert = driver.findElement(By.xpath("//input[last()-1]"));
		alert.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		a.dismiss();
		a.sendKeys("");
		driver.manage().window().fullscreen();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void teardown(){
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		driver.quit();
	}

}
