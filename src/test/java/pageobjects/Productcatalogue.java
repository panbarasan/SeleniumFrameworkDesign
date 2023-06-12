package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents_Resuablemethods;

public class Productcatalogue extends AbstractComponents_Resuablemethods {

	WebDriver driver;

	public Productcatalogue(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));



	@FindBy(css=".mb-3")
	List<WebElement> products;


	@FindBy(css=".ng-animating")
	WebElement spinner;

	By productBy=By.cssSelector(".mb-3"); 

	By addtoCart=By.cssSelector(".card-body button:nth-of-type(2)");
	By toastmessage=By.cssSelector("#toast-container");

	public List<WebElement> getpoductList()
	{	
		waitForElementToApper(productBy);
		return products;
	}

	public WebElement getProductByname(String poductName)
	{
		WebElement product = getpoductList().stream().filter(p->p.findElement(By.cssSelector(".mb-3 b")).getText().contains("ADIDAS")).findFirst().orElse(null);
		//System.out.println(product.getText());

		return product;
	}


	public void addprodctToCart(String poductName)
	{
		WebElement product=getProductByname(poductName);
		product.findElement(addtoCart).click();

		//waitForElementToApper(toastmessage);
		//waitForElementToDisapper(spinner);
		
	}

}
