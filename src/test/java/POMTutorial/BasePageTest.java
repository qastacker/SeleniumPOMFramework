package POMTutorial;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.BasePage;
import resources.base;

public class BasePageTest extends base {

	ExtentReports extent;
	BasePage l;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void bTest() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is initialised");

		driver.manage().window().maximize();
		String path=System.getProperty("user.dir")+"\\reports\\basePage.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Hubstaff - Basic Site Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Azhar");
	}

	@Test
	public void BasicSitePageTest() throws IOException {
		extent.createTest("Basic Site Logo Test");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to New First page");
		
		l = new BasePage(driver);
		String Logotitle = l.getLogoTitle().getText();

		System.out.println(Logotitle);
		Assert.assertEquals(Logotitle, "Hubstaff time tracker app");
		log.info("Successfully verified Logo Title");
		extent.flush();
	}

	@Test
	public void PageTitle() throws InterruptedException {
		extent.createTest("Basic Site Page Title Test");
		Thread.sleep(3000);
		String Pagetitle = l.getPageTitle();

		System.out.println(Pagetitle);
		//Assert.assertEquals(Pagetitle, "Hubstaff Account");
		Assert.assertEquals(Pagetitle, "Hubstaff | Time Tracking and Productivity Monitoring Tool");
		log.info("Successfully verified Page Title");
		extent.flush();
	}

//	@Test
//	public void NavBarTest() {
//
//		WebElement NavBar1 = l.getNavBar1();
//		WebElement NavBar2 = l.getNavBar2();
//
//		// System.out.println(NavBar1);
//		Assert.assertTrue(NavBar1.isDisplayed());
//		log.info("Successfully verified NavBar1 Title");
//		
//		// System.out.println(NavBar2);
//		Assert.assertTrue(NavBar2.isDisplayed());
//		log.info("Successfully verified NavBar2 Title");
//	}

	@AfterTest
	public void aTest() {

		driver.close();
		log.info("Driver is closed");
	}
}
