package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Basepage {
WebDriver driver;
public Basepage(WebDriver driver){
	this.driver=driver;
}


public void inputText(By locotor, String text ){
	driver.findElement(locotor).sendKeys(text);
}

public void click(By locator){
	driver.findElement(locator).click();
}

}
