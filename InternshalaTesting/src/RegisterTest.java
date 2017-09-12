import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest {
	
	WebDriver driver ;
	ResourceBundle rb; // Instance Var
	
	@BeforeTest
	public void preLoad(){
		 rb = ResourceBundle.getBundle("config");
		String path = rb.getString("driverpath");
		String chromeDriver = rb.getString("chrome");
		System.setProperty(chromeDriver, path);
		 driver = new ChromeDriver();
	}
	
	@Test
	public void register(){
		
		//String url = "http://newtours.demoaut.com/";
		String url = rb.getString("websiteurl");
		driver.get(url);
		WebElement registerButton = driver.findElement(By.className("btn-primary"));
		registerButton.click();
		
		
	}
	
	@Test
	public void login(){
		
		//String url = "http://newtours.demoaut.com/";
		//String url = rb.getString("websiteurl");
		//driver.get(url);
	}
	
	@AfterTest
	public void postDestroy(){
		driver.close();
	}

}
