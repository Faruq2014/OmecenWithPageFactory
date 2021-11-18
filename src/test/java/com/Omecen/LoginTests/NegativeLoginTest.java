package com.Omecen.LoginTests;

import org.testng.annotations.Test;

import com.Omecen.Base.BaseTest;
import com.Omecen.LoginPages.LoginPage;

public class NegativeLoginTest extends BaseTest{
	
@Test
public void badPassword() {
	LoginPage lp= new LoginPage(driver);
	lp.userName("admin");
	lp.password("admin");
	lp.siginButton();
	
}
}
