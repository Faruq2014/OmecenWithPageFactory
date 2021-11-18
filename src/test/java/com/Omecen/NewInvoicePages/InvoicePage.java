package com.Omecen.NewInvoicePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	
	public WebDriver driver;

	public InvoicePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="(//*[contains(text(),'New Invoice')])[2]") private WebElement invoice;
	public WebElement invoiceLink() {
		invoice.click();
		return invoice;
	}
	
}
