package button;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptTest {

	public void video() {
		WebDriver driver = new  FirefoxDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.id(""));
		jsExecutor.executeScript("JavascriptExecutor",element);
	}
	
	public void canvas(){
		WebDriver driver = new  FirefoxDriver();
	}

}
