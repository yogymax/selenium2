package com.scp.demos.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.scp.utility.AppConstants;
import com.scp.utility.AppConstants.BrowserTypes;
import com.scp.utility.InitiazeDrivers;

public class TestParams {
	
	@Test
	public void fillPracticeForm() throws Exception{
		WebDriver driver = InitiazeDrivers.launchBrowser(AppConstants.APPLICATION_URL,BrowserTypes.FIREFOX);
		PracticeFormPO practiceFormPage =PageFactory.initElements(driver, PracticeFormPO.class);
		practiceFormPage.fillPracticeForm("Yogesh", "Chame");
		Thread.sleep(AppConstants.APP_DELAY);
		practiceFormPage.selectGender("Male");
		Thread.sleep(AppConstants.APP_DELAY);
		practiceFormPage.selectExperience("7");
		Thread.sleep(AppConstants.APP_DELAY);
		practiceFormPage.enterDate("07/30");
		Thread.sleep(AppConstants.APP_DELAY);
		practiceFormPage.selectProfession("Manual Tester","Automation Tester");
		Thread.sleep(AppConstants.APP_DELAY);
		practiceFormPage.selectContinents("Australia");
		Thread.sleep(AppConstants.APP_DELAY);
		practiceFormPage.selectSeleniumCommands("Browser Commands","Wait Commands");
		Thread.sleep(AppConstants.APP_DELAY);
	}
	
	
	@Test
	public void testDbValues(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
