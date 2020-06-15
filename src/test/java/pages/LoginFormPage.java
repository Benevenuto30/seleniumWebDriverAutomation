package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

	public LoginFormPage(WebDriver driver) {
		super(driver);
	}

	public LoginFormPage typeEmail (String email){
		driver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(email);
		return this;
	}
	public LoginFormPage typePassword (String password){
		driver.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
		return this;
	}
	public SecretPage clickSignIn (){
		driver.findElement(By.linkText("SIGN IN")).click();
		return new SecretPage(driver);
	}
	public SecretPage makeLogin(String email, String password){
//		driver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(email);
//		driver.findElement(By.id("signinbox")).findElement(By.name("Password")).sendKeys(password);
//		driver.findElement(By.linkText("SIGN IN")).click();
		typeEmail(email);
		typePassword(password);
		//clickSignIn();
		return clickSignIn();
	}
}
