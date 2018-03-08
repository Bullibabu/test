package internet.herokuapp.com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestAuth {
  
	 WebDriver wb ;
	@Test
  public void f() {
	  wb.findElement(By.linkText("Basic Auth")).click();
	 /* Alert alert = wb.switchTo().alert();
	  UserAndPassword up = new UserAndPassword("admin","admin");
	  alert.authenticateUsing(up );
	  wb.switchTo().defaultContent();
	  */
	  WebDriverWait wait = new WebDriverWait(wb, 2);
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());     
	  alert.authenticateUsing(new UserAndPassword("admin", "admin"));
	  
	
	  
	  wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Automation\\webdriver\\chromedriver.exe");
	wb=  new ChromeDriver();
	  wb.get("https://the-internet.herokuapp.com/");
	
  }

  @AfterTest
  public void afterTest() {
	  wb.close();
  }

}
