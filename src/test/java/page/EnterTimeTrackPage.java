package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EnterTimeTrackPage {
	private ExtentTest test;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver driver,ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test=test;
	}
	
	public boolean verifyHomePageIsDisplayed(WebDriverWait wait) {
		
		try{
			wait.until(ExpectedConditions.visibilityOf(logoutLink));
			test.log(LogStatus.PASS,"Home Page is Displayed");
			return true;
		}
		catch (Exception e) {
			test.log(LogStatus.FAIL,"Home Page is not Displayed");
			e.printStackTrace();
			return false;
		}
	}
	
}
