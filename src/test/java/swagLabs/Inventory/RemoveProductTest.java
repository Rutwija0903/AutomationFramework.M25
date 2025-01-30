package swagLabs.Inventory;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import swagLabs.GenericUtility.BaseClass;
@Listeners(swagLabs.GenericUtility.ListenersImplementation.class)
public class RemoveProductTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void tc_002_removeProductFromCart(){
		System.out.println("Product Removed");
	}

	
}
