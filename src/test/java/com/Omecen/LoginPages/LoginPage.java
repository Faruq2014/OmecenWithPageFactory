package com.Omecen.LoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//input[@name = 'username']") private WebElement uName;
	public WebElement userName (String enterUserName) {
		uName.clear();
		uName.sendKeys(enterUserName);
		return uName;	
	}

	@FindBy(how=How.NAME,using="password") private WebElement pass;
	public WebElement password(String enterPassword) {
		pass.clear();
		pass.sendKeys(enterPassword);
		return pass;

	}
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Sign In')]") private WebElement sigin;
	public WebElement siginButton() {
		sigin.click();
		return pass;
	}

	public WebElement loginRegTest(String enterUserName, String enterPassword) {
		this.userName(enterUserName);
		this.password(enterPassword);
		this.siginButton();
		return this.siginButton();

	}

}
