package AbstractComponents;

import java.time.Duration;
import java.util.List;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents_Resuablemethods {

	WebDriver driver;



	public AbstractComponents_Resuablemethods(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (css="button[routerlink*=cart]")
	WebElement cart_btn;

	public void goToCardPage()
	{


		//clicking my card button
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[routerlink*=cart]"))));
		//driver.findElement(By.cssSelector("button[routerlink*=cart]")).click();
		waitForElementToBeClickable(cart_btn);
		cart_btn.click();
	}

	public void waitForElementToBeClickable(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cart_btn));
	}
	public void waitForElementToApper(By findBy) {


		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForElementToApper(List<WebElement> ele) {


		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));

	}

	public void waitForElementToDisapper(WebElement element) {


		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	
	public  void waitForElementToAppear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void scrollTillElement(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;//scrolling till elemnt is visible
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}


}
