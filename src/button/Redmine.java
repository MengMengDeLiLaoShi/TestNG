package button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Redmine {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://59.108.56.172/redmine/login?back_url=http%3A%2F%2F59.108.56.172%2Fredmine%2F");
		WebDriverWait driverwait = new WebDriverWait(driver, 15);
		WebElement username = driverwait.until(
				new ExpectedCondition< WebElement>(){
					@Override
					public WebElement apply(WebDriver d) {
						return d.findElement(By.xpath("//input[@name=\"username\"]"));
					}
				}
				) ;
				//driver.findElement(By.xpath("//input[@name=\"username\"]"));
		
//		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		WebElement password = driverwait.until(
				new ExpectedCondition< WebElement>(){
					@Override
					public WebElement apply(WebDriver d) {
						return d.findElement(By.xpath("//input[@name=\"password\"]"));
					}
				}
				) ;
//		WebElement submit = driver.findElement(By.xpath("//input[@name=\"login\"]"));
		WebElement submit = driverwait.until(
				new ExpectedCondition< WebElement>(){
					@Override
					public WebElement apply(WebDriver d) {
						return d.findElement(By.xpath("//input[@name=\"login\"]"));
					}
				}
				) ;
		username.sendKeys("liujiang");
		password.sendKeys("HISliujiang");
		submit.submit(); 
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		ѡȡҽԺ��Ϣ����ǰ̨ϵͳ��������ӣ�������ת http://59.108.56.172/redmine/projects/his_client?jump=welcome
//		Select JumpBox = new Select(driver.findElement(By.xpath("//option[@name=\"project_quick_jump_box\"]")));
//		JumpBox.selectByValue("/redmine/projects/his_client?jump=new_issue");
//		Ҳ����ֱ����ת�������������
		driver.navigate().to("http://59.108.56.172/redmine/projects/his_client/issues/new");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		ѡ���������Ϊ����
		Select issue_tracker_id = new Select(driver.findElement(By.id("issue_tracker_id")));
		issue_tracker_id.selectByValue("3");
		
//		��д����
		WebElement issue_subject = driver.findElement(By.name("issue[subject]"));
		issue_subject.sendKeys("HIS����_����");
		
//		ѡ��״̬Ϊ�ѷ���
		SelectBoxByid("issue_status_id","11",driver);
		
//		ѡ��ָ����Ϊ��
		Select issue_assigned_to_id = new Select(driver.findElement(By.id("issue_assigned_to_id")));
		issue_assigned_to_id.selectByValue("132");
		
//		����
		WebElement commit = driver.findElement(By.name("commit"));
		commit.submit();
		
//		����༭
		WebElement edit = driverwait.until(
				new ExpectedCondition< WebElement>(){
					@Override
					public WebElement apply(WebDriver d) {
						return d.findElement(By.xpath("//div[@id=\"main\"]/div[@id=\"content\"]/div[@class=\"contextual\"]/a[1]"));
					}
				}
				) ;
//		WebElement edit = driver.findElement(By.xpath("//a[@onclick='showAndScrollTo(\"update\"]"));
		edit.click();
		driverwait.until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
//				System.out.println("�༭����ȴ�");
				return d.findElement(By.id("issue_status_id")).isEnabled();
			}
		});
		
		String beforeurl = driver.getCurrentUrl();
		
//		ѡ��״̬Ϊ�ѽ��		
		Select update_status_id = new Select(driver.findElement(By.id("issue_status_id")));
		update_status_id.selectByValue("3");
		
//		��д��ʱΪ8
		WebElement time_entry = driver.findElement(By.name("time_entry[hours]"));
		time_entry.sendKeys("8");

//		ѡ��Ϊϵͳ����
		Select time_entry_activity_id = new Select(driver.findElement(By.id("time_entry_activity_id")));
		time_entry_activity_id.selectByValue("26");
//		�ύ	
		WebElement updatecommit = driver.findElement(By.xpath("//input[@value=\"�ύ\"]"));
		updatecommit.click();
		
		String afterurl = driver.getCurrentUrl();
		
//		if(afterurl==beforeurl){
//			updatecommit.click();
//		}
		
//		����༭
//		WebElement closeedit = driver.findElement(By.xpath("//a[@accesskey=\"e\"]"));
//		WebElement closeedit = driverwait.until(
//				new ExpectedCondition< WebElement>(){
//					@Override
//					public WebElement apply(WebDriver d) {
//						return d.findElement(By.xpath("//div[@id=\"main\"]/div[@id=\"content\"]/div[@class=\"contextual\"]/a[@accesskey=\"e\"]"));
//					}
//				}
//				) ;
//		System.out.println(closeedit.getText());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement closeedit1 = driver.findElement(By.xpath("//div[@id=\"main\"]/div[@id=\"content\"]/div[@class=\"contextual\"]/a[1]"));
		closeedit1.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		ѡ��״̬Ϊ�ѹر�
		Select close_status_id = new Select(driver.findElement(By.id("issue_status_id")));
		close_status_id.selectByVisibleText("�ѹر�");
		WebElement closecommit = driver.findElement(By.xpath("//input[@value=\"�ύ\"]"));
		closecommit.submit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();

	}

	public static void SelectBoxByid(String id,String value,WebDriver driver){
		Select SelectBox = new Select(driver.findElement(By.id(id)));
		SelectBox.selectByValue(value);
	}
}


