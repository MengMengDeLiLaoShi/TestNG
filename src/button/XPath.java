package button;

//import java.io.File;
//import javax.xml.xpath.*;

import java.sql.Driver;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;

public class XPath {
	
	public static void main(String[] args) {
			try{
				System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("http://news.baidu.com/");
				Thread.sleep(3000);
//				WebElement element = driver.findElement(By.xpath("//form/input[2]"));
//				WebElement element = driver.findElement(By.xpath("//form/input[@value=\"female\"]"));
				WebElement element = driver.findElement(By.xpath("//li[@class=\"hdline0\"]/strong/a[@class=\"a3\"]"));
//				WebElement element = driver.findElement(By.cssSelector("input[value='female']"));
				element.click();
				Set<String> WindowsHandle= driver.getWindowHandles();
				for(String wind:WindowsHandle){
					driver.switchTo().window(wind);
					if(driver.getPageSource().contains("四川代表团参加审议")){
						System.out.print(driver.getTitle());
					}
				}
//				XPathFactory factory = XPathFactory.newInstance();
//				XPath xpath = (XPath) factory.newXPath();
				System.out.print(element);
				Thread.sleep(3000);
				driver.quit();
			}catch(Exception e){
				System.out.print(e);				
			}	
			
		}

}
