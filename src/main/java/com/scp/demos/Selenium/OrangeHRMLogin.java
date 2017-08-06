package com.scp.demos.Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scp.utility.InitiazeDrivers;
import com.scp.utility.MyPageFactory;

public class OrangeHRMLogin implements MyPageFactory{
	
	public static Logger log = Logger.getLogger(OrangeHRMLogin.class);
	
	@FindBy(id="txtUsername")
	private WebElement usernameInput;
	
	@FindBy(id="txtPassword")
	private WebElement passwordInput;
	
	@FindBy(id="btnLogin")
	private WebElement signInBtn;
	
	@FindBy(id="spanMessage")
	private WebElement errorMessage;
	
	private void enterUserName(String uname){
		usernameInput.clear();
		usernameInput.sendKeys(uname);
	}
	private void enterPassword(String pwd){
		passwordInput.clear();
		passwordInput.sendKeys(pwd);
	}
	
	public OrangeHRMDashboard enterCredentails(String uname,String pwd){
		log.info("Username > "+uname);
		log.info("Password > "+pwd);
		
		enterUserName(uname);
		enterPassword(pwd);
		return clickSignIn();
	}
	
	private OrangeHRMDashboard clickSignIn(){
		signInBtn.click();
		return PageFactory.initElements(InitiazeDrivers.driver, OrangeHRMDashboard.class);
	}
	public boolean isPageloaded() {
		 try{
			return usernameInput.isDisplayed() && signInBtn.isDisplayed();
		 }catch(Exception e){
			 return false;
		 }
	}
	
	
	public String getErrorMessage(){
		try{
			if(errorMessage.isDisplayed())
				return errorMessage.getText();
		}catch(Exception e){
			return "Element not found";
		}
		return "Element not found";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
