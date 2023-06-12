package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents_Resuablemethods;

public class ConfirmatiionPage extends AbstractComponents_Resuablemethods {
	
WebDriver driver;
	
	public ConfirmatiionPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirm_msg;
	
	public String getConfirmationMessage()
	{
		String msg=confirm_msg.getText();
		
		return msg;
	}

}
