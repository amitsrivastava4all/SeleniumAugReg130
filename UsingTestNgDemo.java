import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsingTestNgDemo {
	@Test(priority=1)
	public void registerTest(){
		
	}
	
	@Test
	public void loginTest(){
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String path = rb.getString("driverpath");
		String chromeDriver = rb.getString("chrome");
		System.setProperty(chromeDriver, path);
		WebDriver driver = new ChromeDriver();
		//String url = "http://newtours.demoaut.com/";
		String url = rb.getString("websiteurl");
		driver.get(url);
		WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys("amitsrivastava");
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys("amit123456");
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
		String title = driver.getTitle().trim();
		driver.close();
		Assert.assertEquals(title, "Find a Flight: Mercury Tours:");
	}

}
