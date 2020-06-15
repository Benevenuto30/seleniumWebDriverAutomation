package tests;
import static org.junit.Assert.*;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.SecretPage;
import support.Web;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformationUsersPageObjectsTest.csv")
public class InformationUsersPageObjectsTest {

	private WebDriver driver;

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
		assertEquals("Hi, Julio",textMe);
	}
	@Test
	public void testLoginFailedWithoutPassword(@Param(name="login")String login){
		String textToastWithoutPassword = new LoginPage(driver)
				.clickSignIn()
				.makeLogin(login,"")
				.captureMessageToastWithoutPassword();

		assertEquals("Maybe you brain dropped the password or login in some place!",textToastWithoutPassword );
	}

	@Test
	public void testAddAdditionalUserInformation(
			@Param(name="login")String login,
			@Param(name="password")String password,
			@Param(name="type")String type,
			@Param(name="contact")String contact,
			@Param(name="expectedMessage")String expectedMessage)
	{
		String textToast = new LoginPage(driver)
				.clickSignIn()
				.makeLogin(login,password)
				.clickOnMe()
				.clickTabMoreDataAboutYou()
				.clickOnButtonAddMoreDataAboutYou()
				.addContact(type,contact)
				.captureMessageToast();
		assertEquals(expectedMessage,textToast);

	}

	@After
	public void tearDown(){
		driver.quit();
	}

}
