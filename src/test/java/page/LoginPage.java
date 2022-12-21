package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {

	private ExtentTest test;
	
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement loginBTN;
	
	public LoginPage(WebDriver driver,ExtentTest test) {
		PageFactory.initElements(driver,this);
		this.test=test;
	}
	
	public void setUserName(String un){
		unTB.sendKeys(un);
		test.log(LogStatus.INFO, "Enter '"+un+"' in User Name text box");
	}
	
	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
		test.log(LogStatus.INFO, "Enter '"+pw+"' in Password text box");
	}
	
	public void clickLoginButton() {
		loginBTN.click();
		test.log(LogStatus.INFO, "click on 'login' button");
	}
}
