package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyTasks extends BasePage{

	public MyTasks(WebDriver driver) {
		super(driver);
	}

	public AddTask clickAddATask(){
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button")).click();
		return new AddTask(driver);
	}

}
