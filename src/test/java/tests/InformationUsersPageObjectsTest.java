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
public class InformationUsersPageObjectsTest {

	private WebDriver driver;

	@Rule
	public TestName test = new TestName();

	@Before
	public void setUp(){
		driver = Web.createChrome();
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
		Screenshot.take(driver,"/Users/larafael.benevenuto/desktop/seleniumAutomation/screenshot/"
				+ Generate.dateTimeForFile()+test.getMethodName()+".png");
	}

	@Test
	public void testRemovePhoneUserInformation(@Param(name="login")String login,
											   @Param(name="password")String password,
											   @Param(name="expectedMessage")String expectedMessage){
		String textToast = new LoginPage(driver)
				.clickSignIn()
				.makeLogin(login,password)
				.clickOnMe()
				.clickTabMoreDataAboutYou()
				.removePhone()
				.captureMessageToast();
		assertEquals(expectedMessage,textToast);
		Screenshot.take(driver,"/Users/larafael.benevenuto/desktop/seleniumAutomation/screenshot/"
				+ Generate.dateTimeForFile()+test.getMethodName()+".png");


	}

	@Test
	public void testRemoveEmailUserInformation(@Param(name="login")String login,
											   @Param(name="password")String password,
											   @Param(name="expectedMessage")String expectedMessage){
		String textToast = new LoginPage(driver)
				.clickSignIn()
				.makeLogin(login,password)
				.clickOnMe()
				.clickTabMoreDataAboutYou()
				.removeEmail()
				.captureMessageToast();
		assertEquals(expectedMessage,textToast);
		Screenshot.take(driver,"/Users/larafael.benevenuto/desktop/seleniumAutomation/screenshot/"
				+ Generate.dateTimeForFile()+test.getMethodName()+".png");


	}
//	@Test
//	public void testCreateTask(@Param(name="login")String login,
//							   @Param(name="password")String password){
//		new LoginPage(driver)
//				.clickSignIn()
//				.makeLogin(login,password)
//				.clickMyTasks()
//				.clickAddATask()
//				.fillDateLimit();
//
//	}

	@After
	public void tearDown(){
		driver.quit();
	}

}
