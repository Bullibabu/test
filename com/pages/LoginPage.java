package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Basepage
{

	By usernameInputLocator = By.id("username");
	By passwordInputLocator = By.id("password");
	By loginButtonLocator = By.cssSelector("button[type='submit']");
public LoginPage(WebDriver driver) {
	super(driver);	
	
	}
    
    public void login()
    {
        //driver.findElement(usernameInputLocator).sendKeys("tomsmith");	
        //driver.findElement(passwordInputLocator).sendKeys("SuperSecretPassword!");
        //driver.findElement(loginButtonLocator).click();
        inputText(usernameInputLocator, "tomsmith");
        inputText(passwordInputLocator, "SuperSecretPassword!");
        click(loginButtonLocator);
        
    	
    }
    




}
