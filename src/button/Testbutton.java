package button;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Testbutton {
	
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setup()throws Exception{
		driver.get("file:///D:/test.html");
		Thread.sleep(3000);
	}
	
	@Test
	public void button()throws Exception{
		WebElement element = driver.findElement(By.xpath("//form/input[@value=\"female\"]"));
		
		if(!element.isSelected()){
			element.click();
		}
		
		assertTrue(element.isSelected());
		
	}
	@After
	public void tearDown()throws Exception{
		driver.close();
	}
}
