package swagLabs.Inventory;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swagLabs.GenericUtility.BaseClass;
import swagLabs.ObjectRepository.CartPage;
import swagLabs.ObjectRepository.InventoryPage;
import swagLabs.ObjectRepository.ProductPage;

@Listeners(swagLabs.GenericUtility.ListenersImplementation.class)
public class AddProductToCart extends BaseClass{

	
	@Test(groups = "SmokeSuite")
	public void tc_001_AddProductToCartTest() throws Throwable {
	
		//Read the test data from excel file
		String PRODUCTNAME = eUtil.readDataFromExcelFile("Inventory", 1, 2);
		System.out.println(PRODUCTNAME);
		
		//Step 3:Add the product to cart: Use Dynamic Xpath to pass ProductName from excel to xpath
				InventoryPage ip = new InventoryPage(driver);
				String productAdded = ip.clickOnAnyProduct(driver, PRODUCTNAME);
				
		//Step 4:Go to cart
				ProductPage pp = new ProductPage(driver);
				pp.clickOnAddToCartBtn();
		
		//Step 5: Navigate to cart		
		//Step 5: Navigate to cart
				ip.clickOnCartContainerBtn();
				
		//Step 6:Validate the added product in cart
				CartPage cp = new CartPage(driver);
				String productInCart = cp.getProductInfo();
			
				Assert.assertEquals(productInCart, productAdded);
				Assert.assertTrue(productInCart.equals(productAdded));
				System.out.println(productInCart);
	}
	
	@Test(retryAnalyzer = swagLabs.GenericUtility.RetryAnalyserImplementation.class)
	public void sampleTest() {
		Assert.fail();
		System.out.println("Sample");
	}

}
