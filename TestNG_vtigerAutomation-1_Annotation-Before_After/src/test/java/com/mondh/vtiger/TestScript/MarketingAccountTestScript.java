package com.mondh.vtiger.TestScript;

import java.util.List;

import org.testng.annotations.Test;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountCreateAccountPage;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountInformationPage;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class MarketingAccountTestScript {

	@Test
	public void verifyVT1010CreateAccounts() throws Exception {
		
	WebUtil	web=new WebUtil();
	System.out.println("verifyVT1010CreateAccounts TestCase Started");
	
	web.lunchbrower();
	web.openUrl("http://localhost:8888");
	web.impliCityTimewait(60);
	
	CommonReusableCode comm=new CommonReusableCode(web);
	comm.velidLogin();	
//DeatailsMarketingAccount:	
	comm.goToMarketingAccountSubmodule();
	comm.createButton();
//marketingCreatePage:
	MarketingAccountCreateAccountPage marketingCreatePage= new MarketingAccountCreateAccountPage(web);
	marketingCreatePage.fillAccountInformationDeatils("rajaBhai");
//Remove_DeatailsMarketingAccount:	
	//comm.goToMarketingAccountSubmodule();	
	MarketingAccountInformationPage marketinginformations=new MarketingAccountInformationPage(web);
	marketinginformations.goToMarketingAccountSubmodule();	
	List<String> tableData=web.getColumnDataListByColumnName("//table[@class='lvt small']", "Account Name");
	System.out.println("verifyVT1010CreateAccounts TestCase Completed");
//sigiOut&CloseDriver:
	comm.userSignOut();
//web.LunchBrowerClose();
	web.driverClose();
	
	
	}
	
	
	
	
	
	
}
