package testngdemos.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Mercury_Test_Listener implements ITestListener{
	
	public ExtentSparkReporter spark;
	public ExtentSparkReporterConfig sparkConfig;
	public ExtentReports extent;
	public ExtentTest extentTest;

	// Implement ITestListener interface methods
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"SampleReport1.html");  //Set the location for report file
		
		spark.config().setDocumentTitle("MercuryTours Automation Report");					  //Set title for the report
		spark.config().setReportName("BasicSanity");										  //Name of the report
		spark.config().setTheme(Theme.DARK);											  //Report theme
		
		extent = new ExtentReports();
		extent.attachReporter(spark);														  
		
		extent.setSystemInfo("Computer Name", "MacPC");
		extent.setSystemInfo("Environment Name", "QA");
		extent.setSystemInfo("Tester Name", "SK");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest = extent.createTest(result.getName());
		extentTest.log(Status.PASS, "Passed Test : " + result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest = extent.createTest(result.getName());
		extentTest.log(Status.FAIL, "Failed Test : " + result.getName());
		extentTest.log(Status.FAIL, "Failed Test : " + result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest = extent.createTest(result.getName());
		extentTest.log(Status.SKIP, "Skipped Test" + result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}


