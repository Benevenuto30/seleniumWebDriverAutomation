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
}
