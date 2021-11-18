package com.Omecen.NewInvoiceTests;

import org.testng.annotations.Test;

import com.Omecen.Base.BaseTest;
import com.Omecen.LoginPages.LoginPage;
import com.Omecen.NewInvoicePages.InvoicePage;

public class InvoiceLinkTest extends BaseTest{
	
	@Test( groups= {"regression","smoke","functional"})
	public void clickInvoiceTest() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.loginRegTest("admin", "admin_test");
		Thread.sleep(5000);
		InvoicePage iv = new InvoicePage(driver);
		iv.invoiceLink();
		
		
	}

}
