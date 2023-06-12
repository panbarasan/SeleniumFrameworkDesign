package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponents_Resuablemethods;

public class CardPage extends AbstractComponents_Resuablemethods {
	
WebDriver driver;
	
	public CardPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> mycarditems = driver.findElements(By.xpath("//div[@class='cart']//h3"));
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(xpath="//div[@class='cart']//h3")
	List<WebElement> mycarditems_list;
	
	@FindBy(css=".totalRow button")
	WebElement checkout_btn;
	
	public boolean verifyTheproductIntheCard(String prodctName)
	{
		
		//waitForElementToApper(mycarditems_list);
		boolean cartitem = mycarditems_list.stream().anyMatch(p->p.getText().contains(prodctName));
		return cartitem;
	}
	
	public void cilickCheckOutButton()
	{
		waitForElementToBeClickable(checkout_btn);
		checkout_btn.click();
		
	}

}


