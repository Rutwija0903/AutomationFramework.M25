package AdvancedSelenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import swagLabs.GenericUtility.ExcelFileUtility;
import swagLabs.GenericUtility.PropertyFileUtility;
import swagLabs.GenericUtility.SeleniumUtility;
import swagLabs.ObjectRepository.LoginPage;

public class AddProductToCartUsingDDTandGU {

	public static void main(String[] args) throws Throwable {
		
		//Create object for utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the common data from property file
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//Read the test data from excel file
		String PRODUCTNAME = eUtil.readDataFromExcelFile("Inventory", 1, 2);
		System.out.println(PRODUCTNAME);
		
		//Step 1: Launching the browser
				WebDriver driver = new ChromeDriver();
				
				sUtil.maximizeWindow(driver);
				sUtil.implicitlyWait(driver);


				driver.get(URL);
				
				//Step 2:Login to application
//				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//				driver.findElement(By.id("password")).sendKeys(PASSWORD);
//				driver.findElement(By.id("login-button")).click();
				
				LoginPage lp = new LoginPage(driver);
//				lp.getUsernameEdt().sendKeys(USERNAME);
//				lp.getPasswordEdt().sendKeys(PASSWORD);
//				lp.getLoginBtn().click();
				
				lp.loginToApp(USERNAME, PASSWORD);
				
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
