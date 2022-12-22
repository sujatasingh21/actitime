package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Util;
import page.LoginPage;

public class InvalidLogin extends BaseTest{
	
	@Test(priority = 2)
	public void testInvalidLogin() {
		String un=Util.getXlData(XL_PATH,"InvalidLogin",1,0);
		String pw=Util.getXlData(XL_PATH,"InvalidLogin",1,1);
		
//		1. enter invalid user name
		LoginPage loginPage=new LoginPage(driver, test);
		loginPage.setUserName(un);
		
//		2. enter invalid password
		loginPage.setPassword(pw);
		
//		3. click login
		loginPage.clickLoginButton();
		
//		4. err msg should be displayed
		boolean result = loginPage.verifyErrMsgIsDisplayed(wait);
		Assert.assertTrue(result,"Err Msg is not displayed");
	}

}
