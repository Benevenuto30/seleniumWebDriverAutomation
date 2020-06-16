package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTask extends BasePage{
	public AddTask(WebDriver driver) {
		super(driver);
	}
	public AddTask fillDateLimit(){
		driver.findElement(By.xpath("//*[@id=\"addtask\"]/div[1]/div[2]/div/input")).sendKeys("Test");
		driver.findElement(By.className("validate datepicker picker__input")).click();
		driver.findElement(By.xpath("//*[@id=\"P326479032_root\"]/div/div/div/div/div[2]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"P1563199483_root\"]/div/div/div/div/div[2]/div[2]/button[3]")).click();
		return this;

	}
}
