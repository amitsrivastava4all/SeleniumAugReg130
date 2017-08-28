import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) throws Exception {
		
		//String windowPath = "d:\\myapp\\chromedriver.exe";
		String path = "/Users/amit/Documents/SeleniumAugBatchWs/chromedriver";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		String url ="https://www.facebook.com";
		driver.get(url);
		//Thread.sleep(7000);
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ramkumar@yahoo.com");
		
		WebElement pwd = driver.findElement(By.id("pass"));
		pwd.sendKeys("r124_6763@");
		Thread.sleep(3000);
		
		// JS Code
		String script = "document.querySelector(\"input[value='Log In']\").click()";
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript(script);
		//System.out.println(By.id("u_0_0")+" "+By.id("u_0_2"));
		//WebElement loginButton = driver.findElement(By.id("u_0_2"));
		//WebElement loginButton2 = driver.findElement(By.id("u_0_0"));
		
		//System.out.println("Login Button is "+loginButton+" "+loginButton2);
		
		//loginButton.click();
		
		
		driver.close();
		

	}

}
