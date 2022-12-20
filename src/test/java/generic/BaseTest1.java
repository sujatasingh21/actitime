package generic;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1 {
	public WebDriver driver;
	public WebDriverWait wait;
	public static ExtentReports extent;
	public ExtentTest test;
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeSuite
	public void createReport() {
		extent = new ExtentReports("target/Spark.html");
	}
	
	@AfterSuite
	public void publishReport() {
		extent.flush();
	}
	
	@BeforeMethod
	public void openApp(Method testMethod)
	{
		test = extent.startTest(testMethod.getName());
		
		test.log(LogStatus.INFO, "Open the Browser");
		driver=new ChromeDriver();
		
		test.log(LogStatus.INFO, "Maximize the Browser");
		driver.manage().window().maximize();
		
		test.log(LogStatus.INFO, "Enter the url:");
		driver.get("https://demo.actitime.com/login.do");
		
		test.log(LogStatus.INFO, "Set implicitlyWait");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		test.log(LogStatus.INFO, "Set ExplicitWait");
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	
	@AfterMethod
	public void closeApp(ITestResult result) throws IOException
	{
		
		int status = result.getStatus();
		if(status==2)
		{
			String errDetails = result.getThrowable().getMessage();
			String testName=result.getName();
			test.log(LogStatus.FAIL, errDetails);
		
			TakesScreenshot t=(TakesScreenshot)driver;
			File srcIMG = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcIMG, new File("./target/"+testName+".png"));
			String htmlcode = test.addScreenCapture(testName+".png");
			test.log(LogStatus.FAIL, htmlcode);
		}
		
		test.log(LogStatus.INFO, "close the Browser");
		driver.quit();
	}
}
