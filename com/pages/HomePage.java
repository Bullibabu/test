package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	By formAuthLinkLocator = By.linkText("Form Authentication");
    


public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	driver.get("http://the-internet.herokuapp.com/");
	}



public LoginPage  clickFormLink(){
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(formAuthLinkLocator).click();
    return new LoginPage(driver);
}
}

