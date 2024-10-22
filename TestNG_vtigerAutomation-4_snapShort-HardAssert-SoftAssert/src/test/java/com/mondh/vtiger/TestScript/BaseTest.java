package com.mondh.vtiger.TestScript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class BaseTest {

	private WebUtil gm = WebUtil.getObject();
	private CommonReusableCode comm;
	
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {

		System.out.println("Before TestScript Suite");
	}
//	@BeforeTest(alwaysRun = true)
//	public void beforeTest() {		
//		System.out.println("DataBase Connect");
//	}
//	

//LunchBrower:	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(String browser) {
		gm.lunchbrower(browser);
		gm.impliCityTimewait(60);
		gm.openUrl("http://localhost:8888");
		
	}
	
//before_group:	
	@BeforeGroups(groups = {"Smoke"},alwaysRun = true)
	public void beforegroup() {
		System.out.println("Smoke_Group");
	}
	@BeforeGroups(groups = {"Regression"},alwaysRun = true)
	public void beforegroup1() {
		System.out.println("After_Group");
	}

//Login:
	@Parameters({"username","password"})
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String userName,String password) {
		comm=new CommonReusableCode(gm);		
		comm.velidLogin(userName,password);
	}

//SignOut:	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {		
		comm.userSignOut();
	}
	
//After_Group:	
	@AfterGroups(groups = {"Smoke"},alwaysRun = true)
	public void aftergroup() {
		System.out.println("After_group");
	}

//DriverQite():	
	@AfterClass(alwaysRun = true)
	public void afterClass() {		
		gm.driverQuit();
	}
	
//	
//	@AfterTest(alwaysRun = true)
//	public void afterTest() {
//		System.out.println("DataBase DisConnect");
//	}
//	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("After TestScript Suite");
	}
	
	
}
