package swagLabs.GenericUtility;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of testng
 * @author Rutwija Haripurkar
 */
public class ListenersImplementation implements ITestListener {

	// Configuring current system date for screenshot name and report name
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	String date = f.format(d);
	
	//For extent reports
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" Test Execution Started");
		
		//Intimate the extent report for each @test execution
		test = report.createTest(methodName);
	}

	
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" Test Pass");
		
		//Log the status as PASS in Extent Report
		test.log(Status.PASS, methodName+" Test Pass");
	}

	
	public void onTestFailure(ITestResult result) {
		//Capture the Test method name
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Test Fail");
		
		//Capture and print the exception
		System.out.println(result.getThrowable());
		
		//Log the status as FAIL in extent report
		test.log(Status.FAIL, methodName+" Test Fail");
		
		//Log the exception captured in Extent Report
		test.log(Status.WARNING, result.getThrowable());
		
		//Formulate Screenshot name
		String screenshotName=methodName+"-"+date;
		SeleniumUtility s = new SeleniumUtility();
		
		try {
			String path = s.CaptureScreenShot(BaseClass.sdriver, screenshotName);
			
			//Attach the screenshot to the Extent Report
			test.addScreenCaptureFromPath(path);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" Test Skipped");
		
		//Capture and print the exception
		System.out.println(result.getThrowable());
		
		//Log the status as skip in Extent Report
		test.log(Status.SKIP, methodName+" Test SKIP" );
		
		//Log the exception captured in extent report
		test.log(Status.WARNING, result.getThrowable());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution Started");
		
		//Extent Report Configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+date+".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Execution Report - Build Version2.3.0 ");
		
		//Attach configuration to extent report class
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows family");
		report.setSystemInfo("Base Environment", "Testing Env");
		report.setSystemInfo("Reporter Name", "Rutwija");
		
	
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution Finished");
		
		//Flush the content to extent report
		report.flush(); //Report will generate
	}
	

}
