package AdvancedSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FilteringProducts {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		
		//Step B:- Load all the keys into properties class
		Properties pro = new Properties();
		pro.load(fis);
		
		//Step C:- Read all the keys using getProperty() method		
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//Step 1: Launching the browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(URL);
				//Step 2:Login to application
				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.id("login-button")).click();
				
			 WebElement filter = driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
			 Select select = new Select(filter);
			 select.selectByVisibleText("Price (low to high)");
			 
	}

}
