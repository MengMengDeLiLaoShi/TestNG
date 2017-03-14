package button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateTest {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		Thread.sleep(5000);
		driver.navigate().to("http://59.108.56.172/redmine");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().forward();
		System.out.print(driver.navigate().toString());
	}

}
