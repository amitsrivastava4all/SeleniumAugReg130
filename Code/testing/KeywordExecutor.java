package com.brainmentors.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class KeywordExecutor {
	ResourceBundle rb =  ResourceBundle.getBundle("config");
	WebDriver driver;
	
	private WebElement getTarget(String target){
		WebElement element = null;
		String array[] = target.split("=");
		String targetVal = array[0];
		if(targetVal.equalsIgnoreCase("id")){
			element = driver.findElement(By.id(array[1]));
		}
		else
		if(targetVal.equalsIgnoreCase("name")){
			element = driver.findElement(By.name(array[1]));
		}
		else
		if(targetVal.equalsIgnoreCase("class")){
				element = driver.findElement(By.className(array[1]));
		}
		else
			if(targetVal.equalsIgnoreCase("xpath")){
					element = driver.findElement(By.xpath(array[1]));
			}
		return element;
	}
	
	private void loadChrome(){
		
			String path = rb.getString("driverpath");
			String chromeDriver = rb.getString("chrome");
			System.setProperty(chromeDriver, path);
			 driver = new ChromeDriver();
	}
	
	private void loadFireFox(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void execute(){
		ArrayList<Keyword> keywords;
		try {
			keywords = ExcelReader.readExcel();
			System.out.println(keywords);
			for(Keyword keyword: keywords){
				if(keyword.getCommand().equalsIgnoreCase("browser")){
					if(keyword.getValue().equalsIgnoreCase("chrome")){
						loadChrome();
					}
					else
					if(keyword.getValue().equalsIgnoreCase("firefox")){
						loadFireFox();
					}
				}
				
				if(keyword.getCommand().equalsIgnoreCase("open")){
					driver.get(keyword.getValue());
				}
				
				if(keyword.getCommand().equalsIgnoreCase("type")){
					String target = keyword.getTarget();
					WebElement element = getTarget(target);
					element.sendKeys(keyword.getValue());
				}
				if(keyword.getCommand().equalsIgnoreCase("click")){
					String target = keyword.getTarget();
					WebElement element = getTarget(target);
					element.click();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
