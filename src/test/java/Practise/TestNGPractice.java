package Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {

	/*	@Test
	public void sampleTest1() {
		System.out.println("Hello World....1");
	}
	
	@Test(priority = 1)
	public void sampleTest2() {
		System.out.println("Hello World....2");
	}
	
	@Test(priority = 0)
	public void sampleTest3() {
		System.out.println("Hello World....3");
	}
	
	@Test
	public void createContact() {
		System.out.println("Contact is created");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void editContact() {
		System.out.println("Contact edited");
	}
	
	@Test(dependsOnMethods = "createContact", enabled = false)
	public void deleteContact() {
		System.out.println("Contact deleted");
	}
	
	@Test(invocationCount = 2, priority = 3)
	public void sampleTest5() {
		System.out.println("Hello World....5");
	}
	
*/	
	
	
//Data Provider
	@Test(dataProvider = "getData")
	public void addProduct(String name, int qty) {
		System.out.println("Phone info is- "+name+" and Qty is - "+qty);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Samsung";
		data[0][1] = 20;
		
		data[1][0] = "Vivo";
		data[1][1] = 10;
		
		data[2][0] = "Iphone";
		data[2][1] = 30;
		
		
		return data;
	}
		

}
