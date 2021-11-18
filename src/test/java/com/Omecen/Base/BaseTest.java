package com.Omecen.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	
	String env="loc";
	
	public void runEnvironment() {
		if (env.equalsIgnoreCase("loc")) {
			System.out.println("run it from local");
		}else { System.out.println("run it from jenkins"+"www.jenkins.com");}
	}
	
	 static {
		 System.out.println("this block is for configure environment");
	 }
	 static {BaseTest bt = new BaseTest();
		 System.out.println("your running environment is......."+bt.env);
	 }
	
	String Browser="chrome";
	
	@BeforeTest( groups= {"regression","smoke","functional"})
	public void OpenApp() {

		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();

		}

		else if (Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();

		}
		else if (Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();

		}else {System.out.println("diver is null");}


		driver.get("https://inventory.omecen.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	
	@AfterTest( groups= {"regression","smoke","functional"})
	public void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}

}
