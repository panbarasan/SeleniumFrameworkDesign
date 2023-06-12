package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents_Resuablemethods;

public class CheckOutPage extends AbstractComponents_Resuablemethods {

	WebDriver driver;

	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//WebElement useremail_txt=driver.findElement(By.id("userEmail"));
	//WebElement password_txt=driver.findElement(By.id("userPassword"));
	//pagefactory

	@FindBy(css="[placeholder*='Country']")
	WebElement Select_Country_txt;
	
	@FindBy(css=".ta-results.list-group.ng-star-inserted")
	WebElement country_result_section;
	
	@FindBy(xpath="//*[@class='ta-results list-group ng-star-inserted']//button//span")
	List<WebElement> suggested_Country;
	
	@FindBy(css=".action__submit")
	WebElement placeorder_btn;

	public void SelectTheCountry(String country)
	{
		//selecting the country
		Actions action=new Actions(driver);
		action.sendKeys(Select_Country_txt, country).build().perform();
		waitForElementToAppear(country_result_section);
		WebElement Expected_Country = suggested_Country.stream().filter(p->p.getText().equals(country)).findFirst().orElse(null);
		Expected_Country.click();
	}
	
	public void clickPlaceOrder()
	{
		
		scrollTillElement(placeorder_btn);
		waitForElementToBeClickable(placeorder_btn);
		placeorder_btn.click();
		
	}

}
