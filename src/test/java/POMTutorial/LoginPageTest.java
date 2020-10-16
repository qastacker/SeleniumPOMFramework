package POMTutorial;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.BasePage;
import Pages.LoginPage;
import resources.base;

public class LoginPageTest extends base {

	ExtentReports extent;
	BasePage l;
	LoginPage lp;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void bTest() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialised");

		driver.manage().window().maximize();
		String path=System.getProperty("user.dir")+"\\reports\\loginPage.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Hubstaff - Guest Login Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Azhar");
	}

	@Test(dataProvider = "getData")
	public void UserLoggedinPageTest(String email, String password, String text) throws InterruptedException {

		extent.createTest("Basic Users Login Test");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to New First page");
//		String url1="https://hubstaff.com/?ab=refresh";
//		String url2="https://hubstaff.com";
//		String currentURL= driver.getCurrentUrl();

//		System.out.println(url1);
//		System.out.println(url2);
//		System.out.println(email);
//		System.out.println(password);
//		System.out.println(text);
//		System.out.println(currentURL);

		l = new BasePage(driver);

//		if(currentURL==url1) {
//			l.getRefreshLogin().click();
//		}else if(currentURL==url2) {
//			l.getLogin().click();
//		}

		l.getRefreshLogin().click();
		log.info("Welcome to First Basic page");

		lp = new LoginPage(driver);
		lp.getEmail().sendKeys(email);
		lp.getPassword().sendKeys(password);
		lp.getLoginBtn().click();
		System.out.println(text);
		Thread.sleep(5000);
		String OrganisationTitle = lp.getOrgName().getText();
		System.out.println(OrganisationTitle);
		// Assert.assertEquals(OrganisationTitle, "Treches");
		log.info("Successfully verified Organisation Title");
		// Thread.sleep(3000);
		WebElement uname = lp.getUserName();
		String uname1 = uname.getText();
		System.out.println(uname1);
		// Assert.assertEquals(uname1, "Yousuf");
		log.info("Successfully verified User Name");
		uname.click();
		// Thread.sleep(3000);
		
		/** Select Dropdown **/
		
		lp.getSignOut().click();
		log.info("Successfully " + uname1 + " Loggged out");
		Thread.sleep(5000);
		extent.flush();
	}

//	@Test
//	public void OrgTitle() {
//		
//		String OrganisationTitle = lp.getOrgName().getText();
//
//		System.out.println(OrganisationTitle);
//		Assert.assertEquals(OrganisationTitle, "Treches");
//		log.info("Successfully verified Organisation Title");
//	}

	@AfterTest
	public void teardown() {

		driver.close();
		log.info("Driver is closed");

	}

	@DataProvider
	public Object[][] getData() {

//		Object[][] data=new Object[3][3];
		Object[][] data = new Object[2][3];

		data[0][0] = "ezizo.zidane.1232@googleappmail.com";
		data[0][1] = "Devtest123@";
		data[0][2] = "Authorised User";

		data[1][0] = "zchah@asdbwegweq.xyz";
		data[1][1] = "Devtest123@";
		data[1][2] = "Second User";
//		
//		data[2][0]="test2@gmail.com";
//		data[2][1]="test123";
//		data[2][2]="Restricted USer";

		return data;
	}

}
