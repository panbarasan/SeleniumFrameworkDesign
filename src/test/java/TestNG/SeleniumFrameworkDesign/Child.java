package TestNG.SeleniumFrameworkDesign;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Child extends Parent {

	@Test
	public void m1() {

		System.out.println("hello");

	}

	@Test
	public void m2() {

		System.out.println("bye");

	}

	@BeforeSuite	
	public void childbeforesuite() {

		System.out.println("child Before suite");

	}
	
	@AfterSuite	
	public void childaftersuite() {

		System.out.println("child after suite");

	}
	
	@BeforeTest	
	public void childbeforetest() {

		System.out.println("child Before test");

	}
	
	@AfterTest	
	public void childaftertest() {

		System.out.println("child after test");

	}
	
	@BeforeClass	
	public void childbeforeclass() {

		System.out.println("child Before class");

	}
	
	@AfterClass	
	public void childafterclass() {

		System.out.println("child after class");

	}
	
	@BeforeMethod	
	public void childbeforemethod() {

		System.out.println("child Before method");

	}
	
	@AfterMethod
	public void childaftermethod() {

		System.out.println("child after method");

	}




}
