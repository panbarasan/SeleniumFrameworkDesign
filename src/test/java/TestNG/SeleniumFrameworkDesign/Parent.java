package TestNG.SeleniumFrameworkDesign;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Parent {
	
	@BeforeSuite	
	public void parentbeforesuite() {

		System.out.println("parent Before suite");

	}
	
	@AfterSuite	
	public void parentaftersuite() {

		System.out.println("parent after suite");

	}
	
	@BeforeTest	
	public void parentbeforetest() {

		System.out.println("parent Before test");

	}
	
	@AfterTest	
	public void prentaftertest() {

		System.out.println("parent after test");

	}

	
	@BeforeClass	
	public void parentbeforeclass() {

		System.out.println("parent Before class");

	}
	
	@AfterClass	
	public void parentafterclass() {

		System.out.println("parent after class");

	}
	
	@BeforeMethod	
	public void parentbeforemethod() {

		System.out.println("parent Before method");

	}
	
	@AfterMethod
	public void parentaftermethod() {

		System.out.println("parent after method");

	}


}
