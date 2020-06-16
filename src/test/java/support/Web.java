package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Web {

	public static WebDriver createChrome(){
		System.setProperty("webdriver.chrome.driver","/Users/larafael.benevenuto/desktop/seleniumAutomation/chromedriver");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.juliodelima.com.br/taskit");
		return driver;
	}
}
