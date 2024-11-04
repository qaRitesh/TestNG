package com.mondh.vtiger.TestScript;

import java.util.List;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountCreateAccountPage;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountInformationPage;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class MarketingAccountTestScript extends BaseTest {

	private WebUtil gm = WebUtil.getObject();
	private CommonReusableCode comm;

//priority = 2,groups = {"Somke","Regression"},dependsOnMethods = {"verifyVT003SearchAccounts" ,""},enabled = true	
	@DataProvider(name="datainformation")
	public Object[][] getDataProvider() {
		String[] data1=new String[6];
			data1[0]="rajaBhai";
			data1[1]="www.bhadohi.com";
			data1[2]="7412589630";
			data1[3]="djmodh";
			data1[4]="@gmai.com";
			data1[5]="1239874565";
			
		String[][] dataProvider=new String[1][6];
				   dataProvider[0]=data1;
				   
		return dataProvider;		   
	}
	
	
	
//Create_Account:	

	@Test(priority =1 , groups = { "Smoke"},dataProvider ="datainformation")
	public void verifyVT001CreateAccounts(String accountName,String website,String tickersymbol,String fax,String email,String phone) throws Exception {
			System.out.println("9");
		gm.getExtTest().log(Status.INFO,"verifyVT001CreateAccounts TestCase Started");
		comm = new CommonReusableCode(gm);
		// MarketingAccount_LeandingPage:
		comm.goToMarketingAccountSubmodule();
		comm.createButton();
		// marketingCreatePage:
		MarketingAccountCreateAccountPage marketingCreatePage = new MarketingAccountCreateAccountPage(gm);
		
		marketingCreatePage.fillAccountInformationDeatils(accountName,website,tickersymbol,fax,email,phone);
		comm.topSaveButton();
		// AccountInformationPage:
		MarketingAccountInformationPage marketinginformations = new MarketingAccountInformationPage(gm);
		marketinginformations.goToMarketingAccountSubmodule();
		comm.checkDataStoreorNot("Account Name", accountName);
		gm.getExtTest().log(Status.INFO,"verifyVT001CreateAccounts TestCase Completed");
	}

//updata_data:	
	@Test(priority = 2, groups = { "Smoke"})
	public void verifyVT002UpdateAccounts() throws Exception {
		gm.getExtTest().log(Status.INFO,"verifyVT002UpdateAccounts TestCase Started");
		comm = new CommonReusableCode(gm);
		// MarketingAccount_LeandingPage:
		comm.goToMarketingAccountSubmodule();
		String clcikItem = "rajaBhai";
		gm.tableItemClick("//table[@class='lvt small']", 3, clcikItem);
		// updata_data:
		MarketingAccountInformationPage marketinginformations = new MarketingAccountInformationPage(gm);
		marketinginformations.clickTopUpdateBT();
		String newText = "Bhairaja";
		MarketingAccountCreateAccountPage marketingAccounPage = new MarketingAccountCreateAccountPage(gm);
		marketingAccounPage.updateAccountName(newText);
		comm.topSaveButton();
		// check_Update:
		marketinginformations.goToMarketingAccountSubmodule();
		comm.checkUpdateData("Account Name", clcikItem, newText);
		gm.getExtTest().log(Status.INFO,"verifyVT002UpdateAccounts TestCase Completed");
		
	}

//Search_Data:	
	@Test(priority = 3, groups = {"Smoke"})
	public void verifyVT003SearchAccounts() throws Exception {
		gm.getExtTest().log(Status.INFO,"verifyVT003SearchAccounts TestCase Started");
		comm = new CommonReusableCode(gm);
//MarketingAccount_LeandingPage:	
		comm.goToMarketingAccountSubmodule();
		String text = "Bhairaja";
		comm.searchTextBox(text);
		String baseOption = "Account Name";
		comm.selectOptionsVisibleText(baseOption);
		comm.searchNowButton();
		comm.checkSearchOptionBaseData(baseOption, text);

		gm.getExtTest().log(Status.INFO,"verifyVT003SearchAccounts TestCase Completed");

	}

//Delete_Data:
	@Test(priority = 4,groups = {"Smoke"})
	public void verifyVT004DeleteAccount() throws InterruptedException {
		gm.getExtTest().log(Status.INFO,"verifyVT004DeleteAccounts TestCase Started");
		comm = new CommonReusableCode(gm);
		// MarketingAccount_LeandingPage:
		comm.goToMarketingAccountSubmodule();
		String deleteText = "Bhairaja";
		gm.tableItemClick("//table[@class='lvt small']", 3, deleteText);
		Thread.sleep(5000);
		MarketingAccountInformationPage marketinginfro = new MarketingAccountInformationPage(gm);
		marketinginfro.clickTopDeleteBT();
		gm.AlertAccepted();
		
		comm.checkDeleteDataOrNot("Account Name", deleteText);
		gm.getExtTest().log(Status.INFO,"verifyVT004DeleteAccounts TestCase Completed");
		
	}

}
