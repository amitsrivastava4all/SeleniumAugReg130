import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver ;
	ResourceBundle rb; 
	@BeforeTest
	public void preLoad(){
		 rb = ResourceBundle.getBundle("config");
		String path = rb.getString("driverpath");
		String chromeDriver = rb.getString("chrome");
		System.setProperty(chromeDriver, path);
		 driver = new ChromeDriver();
	}
	
	@Test
	public void login(){
		driver.get("https://internshala.com/");
		String script = "document.querySelector(\"a[href='/internships/internship-in-delhi']\").click()";
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript(script);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("no_thanks")));
		WebElement popup = driver.findElement(By.id("no_thanks"));
		popup.click();
		 wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_category_chzn']/a/span")));
		script = "document.getElementById(\"select_category_chzn\").children[0].children[0].innerHTML=\"Animation\"";
		js.executeScript(script);
		//WebElement cat = driver.findElement(By.xpath("//*[@id='select_category_chzn']/a/span"));
		
		//cat.sendKeys("Animation");
	}
}
