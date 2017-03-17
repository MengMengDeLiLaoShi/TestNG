package button;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;//远程增量类,使用截图时需要引入
import org.openqa.selenium.remote.DesiredCapabilities;//远程控制类
import org.openqa.selenium.remote.RemoteWebDriver;//远程wdriver类

public class Remote {
	WebDriver driver;
	@Before
	public void setUp(){
		DesiredCapabilities dc = DesiredCapabilities.chrome(); // 设置需要驱动的浏览器，其他的浏览器都是以此类推
		try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:8888/wd/hub"), dc);
			//127.0.0.1服务器地址，8888服务器端口，b以wd/hu结尾不然会抛异常
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); // 设置页面加载超时的最大时长
	}
	@After
	public void tearDown() throws InterruptedException{
		driver.quit();
	}
	@Test
	public void Remote1() throws InterruptedException{
		driver.get("https://www.baidu.com");
		WebDriver augmentdriver = new Augmenter().augment(driver);//实例化WebDriver类指向Augmenter().augment(driver)，在截图中使用
		File Screenshot = ((TakesScreenshot)augmentdriver).getScreenshotAs(OutputType.FILE);//调用getScreenshotAs截图赋值给File Screenshot
		try {
			FileUtils.copyFile(Screenshot, new File("D:\\13.png"));//调用FileUtils类把截图复制到本地
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
