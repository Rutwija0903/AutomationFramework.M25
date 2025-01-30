package AdvancedSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToApplication {

	public static void main(String[] args) throws Throwable {
		
		//Step A:- Path Connection
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		
		//Step B:- Load all the keys into properties class
		Properties pro = new Properties();
		pro.load(fis);
		
		//Step C:- Read all the keys using getProperty() method		
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("Inventory");
		Row rw = sh.getRow(1);
		Cell cell = rw.getCell(2);
		String PRODUCTNAME = cell.getStringCellValue();
		System.out.println(PRODUCTNAME);
		
		//Step 1: Launching the browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(URL);
				
				//Step 2:Login to application
				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.id("login-button")).click();
				
				//Step 3:Add the product to cart: Use Dynamic Xpath to pass ProductName from excel to xpath
				String ProductToBeAddedInCart = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
				driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
				driver.findElement(By.id("add-to-cart")).click();
				
				//Step 4:Go to cart
				driver.findElement(By.id("shopping_cart_container")).click();
				String ProductInTheCart = driver.findElement(By.linkText("Sauce Labs Backpack")).getText();
				
				//Step 5:Validate the added product in cart
				if(ProductInTheCart.equals(ProductToBeAddedInCart)) {
					System.out.println("Pass");
					System.out.println(ProductInTheCart);
				}
				else {
					System.out.println("Fail");
				}

				//Step 6:Logout from application
				driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.id("logout_sidebar_link")).click();
				

	}

}
