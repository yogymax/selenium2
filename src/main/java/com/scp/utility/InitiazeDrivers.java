package com.scp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.scp.utility.AppConstants.BrowserTypes;

public class InitiazeDrivers {
	
	public static Logger logger = Logger.getLogger(InitiazeDrivers.class);
	
	public static WebDriver driver=null;
	
	public static WebDriver launchBrowser(String url, BrowserTypes browserType) throws InvalidBrowserNameExcetion{
		DesiredCapabilities handlSSLErr=null;
		  
		switch(browserType){
			case CHROME :
					logger.info("Initilizing chrome browser");
					handlSSLErr = DesiredCapabilities.chrome();   
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progvaltion_11\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
			case FIREFOX :
					logger.setLevel(Level.ALL);
					logger.fatal("Initilizing Firefox browser");
					logger.error("Initilizing Firefox browser");
					logger.warn("Initilizing Firefox browser");
					logger.info("Initilizing Firefox browser");
					logger.debug("Initilizing Firefox browser");
					logger.trace("Initilizing Firefox browser");
					 handlSSLErr = DesiredCapabilities.firefox();   
					driver = new FirefoxDriver();
					break;
			case IE :
					logger.info("Initilizing IE browser");
					 handlSSLErr = DesiredCapabilities.internetExplorer();
					driver = new InternetExplorerDriver();
					break;
			case SAFARI :
					logger.info("Initilizing Safari browser");
					 handlSSLErr = DesiredCapabilities.safari();  
					driver = new SafariDriver();
					break;
			case EDGE :
					logger.info("Initilizing edge browser");
					 handlSSLErr = DesiredCapabilities.edge();  
					driver = new EdgeDriver();
					break;
			
		}
		
		if(driver==null)
			throw new InvalidBrowserNameExcetion("nit enter kr re....");
		
		handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
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
			
				logger.info("--------------------------");
				logger.info(rset.getInt("CATEGORYID"));
				logger.info("\t\t"+rset.getString("CATEGORYNAME"));
		}
		
		stmt.close();
		connection.close();
		
		
		
		
		//Execute Query
		//Close resources
		
		
		
	}
	
	
	
	
	public static void scrollPageDown(){
		JavascriptExecutor jse = (JavascriptExecutor)InitiazeDrivers.driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	
	
	public static void scrollPageUp(){
		JavascriptExecutor jse = (JavascriptExecutor)InitiazeDrivers.driver;
		jse.executeScript("window.scrollBy(0,-250)");
	}
	
	
	
	
	
	
	
	
	
}
