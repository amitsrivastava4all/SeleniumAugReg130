import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TourDemo {
	
	static void buttonClick(WebDriver driver, String name){
		WebElement button = driver.findElement(By.name(name));
		button.click();
	}
	static void takeText(WebDriver driver, String name , String value){
		WebElement userName = driver.findElement(By.name(name));
		userName.sendKeys(value);
	}
	static WebDriver loadURL(String url){
		String path = "/Users/amit/Documents/SeleniumAugBatchWs/chromedriver";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		return driver;
	}
	
	public static void main(String[] args) throws Exception {

//		String path = "/Users/amit/Documents/SeleniumAugBatchWs/chromedriver";
//		System.setProperty("webdriver.chrome.driver", path);
//		WebDriver driver = new ChromeDriver();
//		String url = "http://newtours.demoaut.com/";
//		driver.get(url);
		WebDriver driver = loadURL("http://newtours.demoaut.com/");
		takeText(driver, "userName", "amitsrivastava");
		takeText(driver, "password", "amit123456");
		buttonClick(driver, "login");
		driver.close();
		/*WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys("amitsrivastava");
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys("amit123456");*/
//		WebElement loginButton = driver.findElement(By.name("login"));
//		loginButton.click();
		//Thread.sleep(3000);
		//driver.close();

	}

}
