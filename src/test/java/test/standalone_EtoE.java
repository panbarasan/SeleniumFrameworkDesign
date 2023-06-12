package test;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CardPage;
import pageobjects.CheckOutPage;
import pageobjects.ConfirmatiionPage;
import pageobjects.LandingPage;
import pageobjects.Productcatalogue;

public class standalone_EtoE {



	@Test
	public void EtoE() throws InterruptedException

	{
		
		String productname="ADIDAS";
		String Country="India";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
		//logging into the application
		LandingPage landingpage=new LandingPage(driver);
		landingpage.goto_url();
		landingpage.login_Application("panbarasan176@gmail.com", "Panbu*2009");
		
		//clicking the poduct based on the prodcut name
		Productcatalogue productcatalougue=new Productcatalogue(driver);
		List<WebElement> products = productcatalougue.getpoductList();
		productcatalougue.addprodctToCart(productname);
		
		//clicking cart button buy using productcatalougue object with the help of inheritance concept
		productcatalougue.goToCardPage();
		//getting the list of my cart items into the list and verify
		CardPage cardpage=new CardPage(driver);
		boolean carditem = cardpage.verifyTheproductIntheCard(productname);
		Assert.assertTrue(carditem);
		
		//clicking checkout button
		cardpage.cilickCheckOutButton();
		
		//selecting the country
		CheckOutPage checkoutpage=new CheckOutPage(driver);
		checkoutpage.SelectTheCountry(Country);
		//clicking place order button
		checkoutpage.clickPlaceOrder();
		
		//Validating "THANKYOU FOR THE ORDER" TEXT message
		ConfirmatiionPage confirmationpage=new ConfirmatiionPage(driver);
		Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmationpage.getConfirmationMessage(), "Expected text is not true");






	}

}
