package com.scp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import com.scp.demos.Selenium.PracticeFormPO;
import com.scp.utility.AppConstants.BrowserTypes;

public class InitiazeDrivers {
	
	public static WebDriver driver=null;
	
	public static WebDriver launchBrowser(String url, BrowserTypes browserType) throws InvalidBrowserNameExcetion{
	
		switch(browserType){
			case CHROME :
					System.out.println("Initilizing chrome browser");
					driver = new ChromeDriver();
					break;
			case FIREFOX :
					System.out.println("Initilizing Firefox browser");
					driver = new FirefoxDriver();
					break;
			case IE :
					System.out.println("Initilizing IE browser");
					driver = new InternetExplorerDriver();
					break;
			case SAFARI :
					System.out.println("Initilizing Safari browser");
					driver = new SafariDriver();
					break;
			case EDGE :
					System.out.println("Initilizing edge browser");
					driver = new EdgeDriver();
					break;
			
		}
		
		if(driver==null)
			throw new InvalidBrowserNameExcetion("nit enter kr re....");
		
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	
	public static void main(String[] args) throws Exception {
		getDbConnection();
	}
	/**
	 * inputbox
	 * Radiobtn
	 * checkbox
	 * link
	 * combobox - multichoice
	 * dropdown - single choice
	 * lable
	 * table
	 * btns
	 * datepicker
	 * image
	 * scoll
	 * waits
	 * autosuggest
	 * tooltip
	 * alert
	 * frame
	 * multiwindow
	 * upload/download files/image
	 * db testing 
	 * api testing - Webservice
	 * mousehovor
	 * screenshot
	 * handle keyboard events
	 * mouse events
	 * page refersh
	 * autoit v3/robot classes
	 * log4j
	 * ejira
	 * db testing
	 * jenkins
	 * test case executions
	 * apache maven
	 * git
	 * testng
	 * FileRead/write - excel read-write
	 * navigations
	 * maximize/minimize window
	 * security certificate
	 * execute test suite on multiple browser
	 * authecation popup
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @throws Exception
	 */
	
	
	
	
	
	
	
	public static void getDbConnection() throws Exception{
		// Load DB Drivers >
		Class.forName("org.hsqldb.jdbcDriver");
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		//1 param - Protocal+IPAddress+Portno+DBName/SchemaName
		//2 Param - Username
		//3 Param - passoword
		//Create Statement
		Statement stmt = connection.createStatement();
		ResultSet rset = stmt.executeQuery("select * from category where categoryid=8");
		while(rset.next()){
			
				System.out.println("--------------------------");
				System.out.print(rset.getInt("CATEGORYID"));
				System.out.print("\t\t"+rset.getString("CATEGORYNAME"));
		}
		
		stmt.close();
		connection.close();
		
		
		
		
		//Execute Query
		//Close resources
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
