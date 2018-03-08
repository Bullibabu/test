package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Authentication {
	WebDriver driver ;
	
	
	
	
	@BeforeTest
	public void browserSetup() {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\webdriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = "http://the-internet.herokuapp.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl) ;
		
	}
	
	
	
	@Test
	public void clikloginFormLink() {
		By formAuthLinkLocator = By.linkText("Form Authentication");
		WebElement formHyperLink =driver.findElement(formAuthLinkLocator);
		formHyperLink.click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/login");
		
	}
	
	@DataProvider(name="userdata")
	public  Object[][] createData(){
		
		return new Object[][] { {"tomsmith","SuperSecretPassword!"} };
		
	}
	
	
	@Test(dataProvider="userdata")
	public void loginFormTest(String username , String password) {
		
		By usernameInputLocator = By.id("username");
		WebElement usernameFiled = driver.findElement(usernameInputLocator);
		
		By passwordInputLocator = By.id("password");
		WebElement passwordLocator = driver.findElement(passwordInputLocator);
		
		By loginButtonLocator = By.cssSelector("button[type='submit']");
		WebElement loginButton = driver.findElement(loginButtonLocator);
		
		
		usernameFiled.sendKeys(username);
		passwordLocator.sendKeys(password);
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		String text=driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String thatWeWant=text.substring(0, text.length()-2);
		
		
		Assert.assertEquals(thatWeWant, "You logged into a secure area!");
		
		
	}
	
	@AfterTest
	public void closeAll() {
		
		
		driver.close();
		driver.quit();
		
	}
	

}