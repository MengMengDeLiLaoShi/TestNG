package button;

import static org.junit.Assert.*;

import java.util.Set;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WindowsTitle {
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setup(){
		try{
			driver.get("https://www.baidu.com/");
			Thread.sleep(5000);
		}catch (Exception e){
			System.out.print(e);
		}		
	}
	
	@Test
	public void WindowsTitl()throws Exception{
		String MasterHandle = driver.getWindowHandle();
		WebElement tj_login = driver.findElement(By.xpath("//div[@id=\"u1\"]/a[@name=\"tj_trnews\"]"));
		tj_login.submit();
		System.out.println(By.xpath("//div[@id=\"u1\"]/a[@name=\"tj_login\"]"));
		Set<String> allWindowsld = driver.getWindowHandles();
		for(String windowld : allWindowsld){
			System.out.print(windowld);
			if(driver.switchTo().window(windowld).getTitle().contains("µÇÂ¼")){
				break;
			}
		}
		
		driver.switchTo().window(MasterHandle);
		WebElement tj_trtieba = driver.findElement(By.xpath("//div[@id=\"u1\"]/a[@name=\"tj_trtieba\"]"));
		tj_trtieba.click();
		
	}
	
	@After
	public void teardown(){
		driver.quit();
	}

}
