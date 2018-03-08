package com.test;

import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Tc_01_LoginTest {
	WebDriver driver;
  @Test
  public void TC_01_LoginTest() {
	  
	  HomePage homeage = new HomePage(driver);
	  LoginPage loginpage =homeage.clickFormLink();
	  loginpage.login();
  }
  @BeforeMethod
  public void beforeMethod() {
	 	
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\webdriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
	  driver.quit();
  }

}
