package swagLabs.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	@FindBy(xpath = "//div[.='Sauce Labs Backpack']")
	private WebElement BackPackProduct;
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutLink;
	
	@FindBy(id = "shopping_cart_container")
	private WebElement cartContainerBtn;
	
	
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBackPackProduct() {
		return BackPackProduct;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getCartContainer() {
		return cartContainerBtn;
	}
	
	/**
	 * This method will click on a particular product whose info is fetched from excel file and 
	 * return to caller
	 * @param driver
	 * @param PRODUCTNAME
	 * @return
	 */
	
	public String clickOnAnyProduct(WebDriver driver, String PRODUCTNAME) {
		String ProductInfo = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
		
		return ProductInfo;
	}
	
	/**
	 * This method will click on backpack product
	 */
	public void clickOnBackPachProduct() {
		BackPackProduct.click();
	}
	
	/**
	 * This method will click on the cart container button
	 */
	public void clickOnCartContainerBtn() {
		cartContainerBtn.click();
	}
	
	/**
	 * This method click on the menu button first and then click on logout button
	 */
	public void clickOnLogoutBtn()
	{
		menuBtn.click();
		logoutLink.click();
		
	}
	
}
