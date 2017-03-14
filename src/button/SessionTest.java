package button;

import org.junit.*;
import java.util.Date;
import java.util.Set;
import java.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionTest {
	
	public static void main(String[] args) throws InterruptedException{
		String name = "zentaosid";
		String value = "ss0puecq93lvu9vc6mfgigglp6";
		String domain = "http://182.92.218.212:8888/";
		String path = "/";
		Date expiry = new Date();
		WebDriver driver = new FirefoxDriver();
		Cookie cookie = new Cookie(name,value,domain,path,expiry);
		driver.get("http://182.92.218.212:8888/zentaopms/www/index.php?m=user&f=login&referer=Lw==");
		Thread.sleep(5000);
		WebElement account = driver.findElement(By.xpath("//input[@name=\"account\"]"));
		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		WebElement keepLoginon = driver.findElement(By.xpath("//input[@id=\"keepLoginon\"]"));
		account.sendKeys("liujiang");
		password.sendKeys("his123456");
		keepLoginon.click();
		WebElement submit = driver.findElement(By.xpath("//button[@data-loading=\"ит╨Р...\"]"));
		submit.click();
		File cookiefile = new  File("D:\\cookie.txt");
		try{
			cookiefile.delete();
			cookiefile.createNewFile();
			FileWriter filewriter = new FileWriter(cookiefile);
			BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			
			for(Cookie cookies : driver.manage().getCookies()){
				bufferedWriter.write(cookies.getName() + ";" + cookies.getValue() + ";" + cookies.getDomain() + ";"
						 + cookies.getPath() + ";" + cookies.getExpiry() + ";" + cookies.isSecure() + ";");
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();
			bufferedWriter.close();
			filewriter.close();			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
