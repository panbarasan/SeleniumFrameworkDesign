package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents_Resuablemethods;

public class LandingPage extends AbstractComponents_Resuablemethods {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElement useremail_txt=driver.findElement(By.id("userEmail"));
	//WebElement password_txt=driver.findElement(By.id("userPassword"));
	//pagefactory
	
	@FindBy(id="userEmail")
	WebElement username_txt;
	
	@FindBy(id="userPassword")
	WebElement password_txt;
	
	@FindBy(id="login")
	WebElement login_btn;
	
	public void login_Application(String email, String password) {
		
		username_txt.sendKeys(email);
		password_txt.sendKeys(password);
		login_btn.click();
		
	}
	
	public void goto_url()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
