package com.scp.demos.Selenium;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.scp.utility.AppConstants;
import com.scp.utility.AppConstants.UserTypes;
import com.scp.utility.InitiazeDrivers;
import com.scp.utility.MyPageFactory;

public class OrangeHRMDashboard implements MyPageFactory {

	public static Logger log = Logger.getLogger(OrangeHRMDashboard.class);
	
	@FindBy(id="menu_admin_viewAdminModule")
	private WebElement adminMenu;

	@FindBy(id="menu_admin_UserManagement")
	private WebElement adminUserManagent;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	private WebElement adminUserMngtUsers;
	
	@FindBy(className="menu")
	private WebElement dashboardMenu;

	@FindBy(id="searchSystemUser_userName")
	private WebElement searchInput;
	
	@FindBy(id="searchSystemUser_userType")
	private WebElement userRoles;

	@FindBy(id="searchBtn")
	private WebElement searchBtn;

	@FindBy(id="resultTable")
	private WebElement table;
	
	public boolean isPageloaded() {
		log.info("inside ispageloaded method");
		 try{
			return dashboardMenu.isDisplayed();
		 }catch(Exception e){
			 return false;
		 }
	}	
	
	public void searchUsers(String searchParam,UserTypes userType) throws Exception{
		adminMenu.click();
		Actions action = new Actions(InitiazeDrivers.driver);
		action.moveToElement(adminUserManagent).build().perform();//.moveToElement(adminUserMngtUsers).build().perform();
		adminUserMngtUsers.click();
		Thread.sleep(AppConstants.APP_DELAY);
		/*searchInput.sendKeys(searchParam);
		selectUserType(userType.toString());
		
		searchBtn.click();*/
	}
	
	
	public void selectUserType(String userType){
		Select select = new Select(userRoles);
		select.selectByVisibleText(userType);
	}
	
	
	public void deleteRecordFromTable(){
		WebElement tbody= table.findElement(By.tagName("tbody"));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			List<WebElement> colms = row.findElements(By.tagName("td"));
					for (WebElement coln : colms) {
						System.out.println(coln.getText());
					}
					System.out.println("########################");
		}
		
	}
	
	
	
	
	
	
	
	
	
}











