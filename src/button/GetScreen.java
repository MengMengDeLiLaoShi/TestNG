package button;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetScreen {
	public static void main(String[] args) throws IOException{
		WebDriver driver  = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("d:\\1.png"));
		driver.quit();
	}

}
