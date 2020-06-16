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
	public MePage removePhone(){
		driver.findElement(By.xpath("//span[text()=\"+5531999998888\"]/following-sibling::a")).click();
		driver.switchTo().alert().accept();
		return this;
	}
	public MePage removeEmail(){
		driver.findElement(By.xpath("//span[text()=\"rafael@test.com\"]/following-sibling::a")).click();
		driver.switchTo().alert().accept();
		return this;
	}
	public AddContactPage clickOnButtonAddMoreDataAboutYou(){
		driver.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		return new AddContactPage(driver);
	}
}
