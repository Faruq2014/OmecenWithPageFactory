package com.Omecen.LoginTests;

import org.testng.annotations.Test;

import com.Omecen.Base.BaseTest;
import com.Omecen.LoginPages.LoginPage;

public class PositiveLoginTest extends BaseTest{

	@Test( groups= {"regression","smoke","functional"})
	public void validCredentialTest() {
		LoginPage lp = new LoginPage(driver);
		//lp.loginRegTest("admin", "admin_test");
		lp.userName("admin");
		lp.password("admin_test");
		lp.siginButton();
		
	}
	

}
