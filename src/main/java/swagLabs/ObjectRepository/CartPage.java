package swagLabs.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	//Declaration
	@FindBy(id = "item_4_title_link")
	private WebElement ItemName;
	
	//Initialization
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getItemName() {
		return ItemName;
	}
	
	//Business Library
	/**
	 * This method get the text of the product info
	 * @return 
	 */
	public String getProductInfo() {
		return ItemName.getText();
	
	}
	
	

}
