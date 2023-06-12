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

public class standalone_EtoE2 {



	@Test
	public void EtoE() throws InterruptedException

	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("userEmail")).sendKeys("panbarasan176@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Panbu*2009");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		//getting all the products and click desired one 
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement product = products.stream().filter(p->p.findElement(By.cssSelector(".mb-3 b")).getText().contains("ADIDAS")).findFirst().orElse(null);
		System.out.println(product.getText());
		product.findElement(By.cssSelector(".card-body button:nth-of-type(2)")).click();

		//waiting until product added to the card message is getting displayed
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));//using webelement
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container)));//using By selector

		System.out.println(driver.findElement(By.cssSelector("#toast-container")).getText());
		//waiting untill invisible of blinking
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		//clicking my card button
		driver.findElement(By.cssSelector("button[routerlink*=cart]")).click();

		//getting the list of my cart items into the list
		List<WebElement> mycarditems = driver.findElements(By.xpath("//div[@class='cart']//h3"));
		boolean cartitem = mycarditems.stream().anyMatch(p->p.getText().contains("ADIDAS"));
		Assert.assertTrue(cartitem);
		
		//clicking checkout button
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//selecting the country
		Actions action=new Actions(driver);
		action.sendKeys(driver.findElement(By.cssSelector("[placeholder*='Country']")), "India").build().perform();
		
		List<WebElement> listof_country_reslts = driver.findElements(By.xpath("//*[@class='ta-results list-group ng-star-inserted']//button//span"));
		
		WebElement country = listof_country_reslts.stream().filter(p->p.getText().equals("India")).findFirst().orElse(null);
		
		country.click();
		
		//clicking place order button
		JavascriptExecutor js = (JavascriptExecutor) driver;//scrolling till elemnt is visible
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(".action__submit")));
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		//Validating "THANKYOU FOR THE ORDER" TEXT message
		
		Assert.assertEquals("THANKYOU FOR THE ORDER.", driver.findElement(By.cssSelector(".hero-primary")).getText(), "Expected text is not true");






	}

}
