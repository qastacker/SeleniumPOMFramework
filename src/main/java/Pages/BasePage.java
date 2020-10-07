package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	public WebDriver driver;
	By signIn = By.xpath("//a[contains(text(),'Sign in')]");
	By refreshSignIn = By.xpath("//header/div[1]/nav[1]/div[3]/ul[1]/li[9]/a[1]");
	By logoTitle = By.xpath("//header/div[1]/nav[1]/div[2]/span[1]/*[1]");
	By navbar1 = By.cssSelector("#hsds-nav-menu>ul>li>div");
	By navbar2 = By.cssSelector("#hsds-nav-menu>ul>li>a");
	
	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signIn);
	}
	
	public WebElement getRefreshLogin() {
		return driver.findElement(refreshSignIn);
	}
	
	public WebElement getLogoTitle() {
		return driver.findElement(logoTitle);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public WebElement getNavBar1() {
		return driver.findElement(navbar1);
	}
	
	public WebElement getNavBar2() {
		return driver.findElement(navbar2);
	}
}
