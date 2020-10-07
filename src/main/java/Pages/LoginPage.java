package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By email = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By clickLogin = By.xpath("//button[text()='Log in']");
	By OrgName = By.cssSelector("strong.selected-value");
	By UserName = By.cssSelector("span.user-name");
	By signOut = By.xpath("//a[contains(text(),'Sign out')]");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(clickLogin);
	}

	public WebElement getOrgName() {
		return driver.findElement(OrgName);
	}
	
	public WebElement getUserName() {
		return driver.findElement(UserName);
	}
	
	public WebElement getSignOut() {
		return driver.findElement(signOut);
	}
}
