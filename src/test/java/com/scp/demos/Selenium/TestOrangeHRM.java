package com.scp.demos.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.scp.utility.AppConstants;
import com.scp.utility.AppConstants.BrowserTypes;
import com.scp.utility.AppConstants.UserTypes;
import com.scp.utility.InitiazeDrivers;
import com.scp.utility.InvalidBrowserNameExcetion;

public class TestOrangeHRM {
	
	@Test(enabled=false)
	public void testLogin(){
		try {
			WebDriver driver = InitiazeDrivers.launchBrowser(AppConstants.ORANGEHRM_LANDING_URL,BrowserTypes.FIREFOX);
			OrangeHRMLogin hrmLogin = PageFactory.initElements(driver, OrangeHRMLogin.class);
			hrmLogin.enterCredentails("Admin","admin");
		} catch (InvalidBrowserNameExcetion e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearchFunctionality(){
		try {
			WebDriver driver = InitiazeDrivers.launchBrowser(AppConstants.ORANGEHRM_LANDING_URL,BrowserTypes.FIREFOX);
			OrangeHRMLogin hrmLogin = PageFactory.initElements(driver, OrangeHRMLogin.class);
			OrangeHRMDashboard dashboardPage = hrmLogin.enterCredentails("Admin","admin");
			
			dashboardPage.searchUsers("xaxaxa", UserTypes.Admin);
			dashboardPage.deleteRecordFromTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}










