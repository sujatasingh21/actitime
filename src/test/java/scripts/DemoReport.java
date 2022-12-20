package scripts;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoReport {

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports("target/Spark.html");
		ExtentTest t1 = extent.startTest("test1");
		t1.log(LogStatus.PASS,"this is pass");
		
		ExtentTest t2 = extent.startTest("test2");
		t2.log(LogStatus.UNKNOWN,"this is SKIP");
		t2.log(LogStatus.INFO,"this is INFO");
		t2.log(LogStatus.PASS,"this is pass");
		t2.log(LogStatus.SKIP,"this is SKIP");
		t2.log(LogStatus.WARNING,"this is WARNING");
		t2.log(LogStatus.ERROR,"this is Error");
		t2.log(LogStatus.FAIL,"this is FAIL");
		t2.log(LogStatus.FATAL,"this is FATAL");
		
		extent.flush();
		System.out.println("End");
	}

}
