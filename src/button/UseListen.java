package button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import button.WebDriverListen;

public class UseListen {

	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		EventFiringWebDriver eventFiriingDriver = new EventFiringWebDriver(driver);
		WebDriverListen mylisten = new WebDriverListen();
		eventFiriingDriver.register(mylisten);//
		eventFiriingDriver.get("https://www.baidu.com");
		eventFiriingDriver.navigate().to("http://news.baidu.com/");
		eventFiriingDriver.navigate().back();
		eventFiriingDriver.findElement(By.id("su")).click();
		driver.quit();
	}
}
