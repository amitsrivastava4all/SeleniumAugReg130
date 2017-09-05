import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.internal.PropertiesFile;

public class PropertyReaderDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//String path = "/Users/amit/Documents/SeleniumAugBatchWs/chromedriver";
		//System.setProperty("webdriver.chrome.driver", path);
		//Properties prop = new Properties();
		//prop.load(new FileInputStream("config.properties"));
		//prop.save
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String path = rb.getString("driverpath");
		String chromeDriver = rb.getString("chrome");
		System.setProperty(chromeDriver, path);
		WebDriver driver = new ChromeDriver();
		//String url = "http://newtours.demoaut.com/";
		String url = rb.getString("websiteurl");
		driver.get(url);

	}

}
