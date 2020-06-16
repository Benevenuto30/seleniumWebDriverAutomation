package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretPage extends BasePage{

	public SecretPage(WebDriver driver) {
		super(driver);
	}

	public MePage clickOnMe(){
		driver.findElement(By.className("me")).click();
		return new MePage(driver);
	}
	public MyTasks clickMyTasks(){
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]/a"));
		driver.findElement(By.linkText("My tasks")).click();
		return new MyTasks(driver);
	}
}
