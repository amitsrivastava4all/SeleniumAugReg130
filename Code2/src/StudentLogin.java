import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StudentLogin {
	
	WebDriver driver ;
	ResourceBundle rb; 
	Logger logger = Logger.getLogger(StudentLogin.class);
	@BeforeTest
	public void preLoad(){
		
		 rb = ResourceBundle.getBundle("config");
		String path = rb.getString("driverpath");
		String chromeDriver = rb.getString("chrome");
		System.setProperty(chromeDriver, path);
		 driver = new ChromeDriver();
		 logger.debug("Driver is Loaded");
	}
	
	@DataProvider(name="mystudentdataprovider")
	public Object[][] getStudentData(){
		Object[][] array=null;
		try {
			// Call Excel and get the data in 2-d array
			//array = ExcelReader.readExcel();
			array = DB.getAllUsers("Y");
			logger.debug("Data Provider Data is COme from Excel... "+array.length);
		} catch (Exception e) {
			logger.error("Problem in  Reading Excel or DB File "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
		
	}
 	
	@Test(dataProvider="mystudentdataprovider")   // Integerate Test with Data Provider
	public void loginAsStudent(String emailId , String password){
		logger.debug("EMail is Rec "+emailId+" and Password "+password);
		String url = "https://internshala.com/login/student";
		driver.get(url);
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(emailId);
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys(password);
		WebElement loginButton = driver.findElement(By.id("login_submit"));
		loginButton.click();
		logger.debug("Login as Student is Done...");
	}
	
	@AfterTest
	public void endTest(){
		driver.close();
		logger.debug("Browser Session is Close");
	}

}
