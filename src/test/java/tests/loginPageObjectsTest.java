package tests;
import static org.junit.Assert.*;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Generate;
import support.Screenshot;
import support.Web;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformationUsersPageObjectsTest.csv")

public class loginPageObjectsTest {
	private WebDriver driver;

	@Rule
	public TestName test = new TestName();

	@Before
	public void setUp(){
		driver = Web.createChrome();
	}

	@Test
	public void testLoginSuccess (@Param(name="login")String login,
								  @Param(name="password")String password)
	{
		String textMe  = new LoginPage(driver)
				.clickSignIn()
				.makeLogin(login,password)
				.captureTextMe();
		assertEquals("Hi, Rafael",textMe);
		Screenshot.take(driver,"/Users/larafael.benevenuto/desktop/seleniumAutomation/screenshot/"
				+ Generate.dateTimeForFile()+test.getMethodName()+".png");
	}
	@Test
	public void testLoginFailedWithoutPassword(@Param(name="login")String login){
		String textToastWithoutPassword = new LoginPage(driver)
				.clickSignIn()
				.makeLogin(login,"")
				.captureMessageToastWithoutPassword();

		assertEquals("Maybe you brain dropped the password or login in some place!",textToastWithoutPassword);
		Screenshot.take(driver,"/Users/larafael.benevenuto/desktop/seleniumAutomation/screenshot/"
				+ Generate.dateTimeForFile()+test.getMethodName()+".png");
	}

	@After
	public void tearDown(){
		driver.quit();
	}
}
