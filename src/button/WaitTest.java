package button;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WaitTest {
	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		WebElement search = driver.findElement(By.xpath("//input[@id=\"kw\"]"));
		search.sendKeys("selenium");
		search.submit();
		WebDriverWait driverwait = new WebDriverWait(driver, 10);
		driverwait.until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
				return d.getTitle().toLowerCase().startsWith("selenium");
			}
		});
		System.out.println(driver.getTitle());
		System.out.println(new Date());
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement search1 = driver.findElement(By.xpath("//input[@id=\"kw\"]"));
		search1.sendKeys("selenium");
		WebElement search2 = driver.findElement(By.xpath("//input[@id=\"su\"]"));
		search2.click();
		System.out.println(driver.getTitle());
		System.out.println(new Date());
		WebElement search3 = driver.findElement(By.xpath("//input[@id=\"kwa\"]"));
		driver.quit();
	}
}
