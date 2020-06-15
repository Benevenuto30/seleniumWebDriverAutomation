package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {
	public MePage(WebDriver driver) {
		super(driver);
	}
	public MePage clickTabMoreDataAboutYou(){
		driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		return this;
	}
	public AddContactPage clickOnButtonAddMoreDataAboutYou(){
		driver.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		return new AddContactPage(driver);
	}
}
