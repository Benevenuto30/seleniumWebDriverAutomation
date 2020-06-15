package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage {

	public AddContactPage(WebDriver driver) {
		super(driver);
	}

	public AddContactPage chooseTypeOfContact (String type){
		WebElement fieldType = driver.findElement(By.id("addmoredata")).findElement(By.name("type"));
		new Select(fieldType).selectByVisibleText(type);
		return this;
	}
	public AddContactPage typeContact (String contact){
		driver.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contact);
		return  this;

	}
	public MePage clickSave (){
		driver.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();
		return new MePage(driver);
	}
	public MePage addContact (String type, String contact){
		chooseTypeOfContact(type);
		typeContact(contact);
		clickSave();
		return new MePage(driver);
	}
}
