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
import org.openqa.selenium.remote.Augmenter;//Զ��������,ʹ�ý�ͼʱ��Ҫ����
import org.openqa.selenium.remote.DesiredCapabilities;//Զ�̿�����
import org.openqa.selenium.remote.RemoteWebDriver;//Զ��wdriver��

public class Remote {
	WebDriver driver;
	@Before
	public void setUp(){
		DesiredCapabilities dc = DesiredCapabilities.chrome(); // ������Ҫ�����������������������������Դ�����
		try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:8888/wd/hub"), dc);
			//127.0.0.1��������ַ��8888�������˿ڣ�b��wd/hu��β��Ȼ�����쳣
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); // ����ҳ����س�ʱ�����ʱ��
	}
	@After
	public void tearDown() throws InterruptedException{
		driver.quit();
	}
	@Test
	public void Remote1() throws InterruptedException{
		driver.get("https://www.baidu.com");
		WebDriver augmentdriver = new Augmenter().augment(driver);//ʵ����WebDriver��ָ��Augmenter().augment(driver)���ڽ�ͼ��ʹ��
		File Screenshot = ((TakesScreenshot)augmentdriver).getScreenshotAs(OutputType.FILE);//����getScreenshotAs��ͼ��ֵ��File Screenshot
		try {
			FileUtils.copyFile(Screenshot, new File("D:\\13.png"));//����FileUtils��ѽ�ͼ���Ƶ�����
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
