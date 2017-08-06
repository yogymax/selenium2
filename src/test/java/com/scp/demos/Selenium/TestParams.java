package com.scp.demos.Selenium;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.scp.utility.AppConstants;
import com.scp.utility.AppConstants.BrowserTypes;
import com.scp.utility.InitiazeDrivers;
import com.scp.utility.InvalidBrowserNameExcetion;

public class TestParams {
	
	@Test(enabled=false)
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
	
	
	@Test(enabled=false)
	public void testUploadFile() throws InvalidBrowserNameExcetion, InterruptedException, AWTException{
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
		practiceFormPage.uploadFile("C:\\Users\\Progvaltion_11\\Desktop\\Other\\demo1.txt");
		practiceFormPage.selectContinents("Australia");
		Thread.sleep(AppConstants.APP_DELAY);
		practiceFormPage.selectSeleniumCommands("Browser Commands","Wait Commands");
		Thread.sleep(AppConstants.APP_DELAY);
	}
	
	@Test
	public void scrollPageDemo() throws InvalidBrowserNameExcetion, InterruptedException{
		WebDriver driver = InitiazeDrivers.launchBrowser(AppConstants.APPLICATION_URL,BrowserTypes.FIREFOX);
	
		for(int i=0;i<10;i++){
			Thread.sleep(1000);
			if(i%2!=0){
				InitiazeDrivers.scrollPageUp();
			}else
				InitiazeDrivers.scrollPageDown();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
