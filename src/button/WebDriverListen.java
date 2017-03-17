package button;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverListen extends AbstractWebDriverEventListener{
	
	@Override//重写方法时使用这个参数，编译器会去校验重写方法的正确性，不正确会抛异常，不加这个参数编译器会以为是新写了一个方法
	public void afterNavigateTo(String url,WebDriver driver){
		System.out.println("After Navigate To" + url);
	}
	@Override
	public void afterNavigateBack(WebDriver driver){
		System.out.println("After Navigate Back To" + driver.getCurrentUrl());
	}
	@Override
	public void afterClickOn(WebElement webElement,WebDriver driver){
		System.out.println("After Click on" + webElement.getText());
	}
}

