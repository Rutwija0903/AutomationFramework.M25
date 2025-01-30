
package swagLabs.GenericUtility;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



/**
 * This class consists of generic methods related to Selenium
 * @author Rutwija Haripurkar
 */

public class SeleniumUtility {
	
/**
 * This method will maximize window
 * @param driver
 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();	
	}
	
	/**
	 * This method will minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method waits till the page load
	 */
	public void implicitlyWait(WebDriver driver) 
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10s for a particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	/**
	 * This method will wait for 10s for a particular element to be clickable
	 * @param driver
	 *  @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle drop-down by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop-down by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method will handle drop-down by visible text
	 * @param element
	 * @param value
	 */
	public void handleDropDownByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);;
	}
	
	/**
	 * This method will perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,  WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	
	public void dragAndDropAction(WebDriver driver,  WebElement drag, WebElement drop) {
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
	}
	
	/**
	 * This method is to double click on element
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) 
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method is to right click on element
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver, WebElement element) 
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform scroll action
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This method move the cursor with particular offset
	 * @param driver
	 */
	public void moveByOffsetAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveByOffset(10, 20).click().perform();
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void switchFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by frame name attribute or frame id attribute
	 * @param driver
	 * @param nameORId
	 */
	public void switchFrameByNameOrIdAttribute(WebDriver driver, String nameORId) {
		driver.switchTo().frame(nameORId);
	}
	
	/**
	 * This method will handle frame by frame Element
	 * @param driver
	 * @param element
	 */
	public void switchFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will handle frame by switching frame to the immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This will handle frame by switching frame to main frame 
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	
	
	/**
	 * This method is to accept the alert popup
	 * @param driver
	 */
	public void acceptTheAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is to dismiss/cancel the alert popup
	 * @param driver
	 */
	public void dismissTheAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is to capture text from the alert popup
	 * @param driver
	 */
	public void getTheAlertText(WebDriver driver) {
		driver.switchTo().alert().getText();
		}
	
	/**
	 * This method is to send the info to the alert popup
	 * @param driver
	 */
	public void enterTheAlertInfo(WebDriver driver, String info) {
		driver.switchTo().alert().sendKeys(info);
		}
	
	
	
	/**
	 * This method will capture the screenshot and return the path to caller
	 * @param driver
	 * @param FilePath
	 * @return 
	 * @throws Throwable
	 */
	public String CaptureScreenShot(WebDriver driver, String screenshotName ) throws Throwable 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShot\\"+screenshotName+".png");
	    Files.copy(src, dest);
	    
	    //for extent reports
	    return dest.getAbsolutePath();
	}
	
}
