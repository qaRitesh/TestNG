package com.mondh.vtiger.TestScript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class BaseTest {

	private WebUtil gm = WebUtil.getObject();
	private CommonReusableCode comm;
	
	
//	@BeforeSuite
//	public void beforeSuite() {
//
//		System.out.println("Before TestScript Suite");
//	}
//	@BeforeTest
//	public void beforeTest() {		
//		System.out.println("DataBase Connect");
//	}
//	
//	@BeforeClass
//	public void beforeClass() {
////LunchBrower:
//		gm.lunchbrower();
//		gm.openUrl("http://localhost:8888");
//	}
		
	@BeforeMethod
	public void beforeMethod() {
//Login LunchBrower:
		gm.lunchbrower();
		gm.openUrl("http://localhost:8888");
		comm=new CommonReusableCode(gm);
		gm.impliCityTimewait(60);
		comm.velidLogin();
	}
		
	@AfterMethod
	public void afterMethod() {
//SignOut DriverQite:		
		comm.userSignOut();
		gm.driverQuit();
	}
	
//	@AfterClass
//	public void afterClass() {
//		//DriverQite():
//		gm.driverQuit();
//	}
//	
//	@AfterTest
//	public void afterTest() {
//		System.out.println("DataBase DisConnect");
//	}
//	
//	@AfterSuite
//	public void afterSuite() {
//		System.out.println("After TestScript Suite");
//	}
	
	
}
