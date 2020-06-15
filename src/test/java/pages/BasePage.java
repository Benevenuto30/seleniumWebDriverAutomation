package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	protected WebDriver driver;
	public BasePage(WebDriver driver){
		this.driver = driver;
	}

	public String captureMessageToastWithoutPassword (){
		return driver.findElement(By.id("toast-container")).getText();
	}
	public String captureMessageToast (){
		return driver.findElement(By.id("toast-container")).getText();
	}
	public String captureTextMe(){
	 String captureTextMe = driver.findElement(By.className("me")).getText();
		System.out.println(captureTextMe);
		return captureTextMe;
	}
}
