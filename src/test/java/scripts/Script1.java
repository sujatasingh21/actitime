package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.BaseTest;

public class Script1 extends BaseTest
{
	@Test(priority = 1)
	public void createCustomer()
	{
		test.log(LogStatus.PASS,driver.getTitle());
//		Assert.fail("Home page is not displayed");
	}
}
