package button;

import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetSession {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException, InterruptedException{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://182.92.218.212:8888/zentaopms/www/index.php?m=user&f=login");
		try {
			File file = new File("D:\\cookie.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufferedreader = new BufferedReader(filereader);
			String line;
			Thread.sleep(5000);
			while((line = bufferedreader.readLine()) != null){
				StringTokenizer stringtokenizer = new StringTokenizer(line,";");
				while(stringtokenizer.hasMoreTokens()){
					String name = stringtokenizer.nextToken();
					System.out.println(name);
					String value = stringtokenizer.nextToken();
					System.out.println(value);
					String domain = stringtokenizer.nextToken();
					System.out.println(domain);
					String path = stringtokenizer.nextToken();
					System.out.println(path);
					Date  expiry = null;
					String dt;
					if(!(dt= stringtokenizer.nextToken()).equals("null")){
						expiry = new Date(dt);
					}
					System.out.println(expiry);
					boolean isSecure = new Boolean(stringtokenizer.nextToken()).booleanValue();
					System.out.println(isSecure);
					Cookie cookie = new Cookie(name,value,domain,path,expiry,isSecure);
					driver.manage().addCookie(cookie);
						
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get("http://182.92.218.212:8888/");
		driver.quit();
	}

}
