package com.scp.demos.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scp.utility.AppConstants;
import com.scp.utility.AppConstants.BrowserTypes;
import com.scp.utility.AppConstants.UserTypes;

import junit.framework.Assert;

import com.scp.utility.InitiazeDrivers;
import com.scp.utility.InvalidBrowserNameExcetion;

public class TestOrangeHRM {
	
	@DataProvider(name="xyz")
	public Object[][] credentails(){
		
		//No of times you want to execute the test case -- no of users
		// no parameters to ur method
		Object[][] testData = new Object[5][3];
		testData[0][0]="Admin";
		testData[0][1]="admin";
		testData[0][2]="SuccessFul";
		
		testData[1][0]="Admin";
		testData[1][1]="admin21321";
		testData[1][2]="Invalid credentials";
		
		testData[2][0]="";
		testData[2][1]="admin";
		testData[2][2]="Username cannot be empty";
		
		testData[3][0]="Admin";
		testData[3][1]="";
		testData[3][2]="Password cannot be empty";
		
		testData[4][0]="";
		testData[4][1]="";
		testData[4][2]="Username cannot be empty";
		
		return testData;
		
	}
	
	
	@Test(dataProvider="xyz")
	public void testLogin(String username,String password,String exMsg){
		try {
			
			WebDriver driver = InitiazeDrivers.launchBrowser(AppConstants.ORANGEHRM_LANDING_URL,BrowserTypes.FIREFOX);
			OrangeHRMLogin hrmLogin = PageFactory.initElements(driver, OrangeHRMLogin.class);
			OrangeHRMDashboard dashboard = hrmLogin.enterCredentails(username,password);
			
			System.out.println("exepcted Msg >" +exMsg);
			String actualErrorMsg = hrmLogin.getErrorMessage();
			if(actualErrorMsg.equals("Element not found")){
				Assert.assertNotNull(dashboard);
			}else{
				Assert.assertEquals(exMsg, actualErrorMsg);
			}
				
			
			
		} catch (InvalidBrowserNameExcetion e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled=false)
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










