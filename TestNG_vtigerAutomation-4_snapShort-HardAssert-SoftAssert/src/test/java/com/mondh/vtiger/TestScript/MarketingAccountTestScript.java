package com.mondh.vtiger.TestScript;

import java.util.List;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountCreateAccountPage;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountInformationPage;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class MarketingAccountTestScript extends BaseTest {

	private WebUtil gm = WebUtil.getObject();
	private CommonReusableCode comm;

//priority = 2,groups = {"Somke","Regression"},dependsOnMethods = {"verifyVT003SearchAccounts" ,""},enabled = true	

//Create_Account:	

	@Test(priority =1 , groups = { "Smoke" })
	public void verifyVT001CreateAccounts() throws Exception {

		System.out.println("verifyVT001CreateAccounts TestCase Started");

		comm = new CommonReusableCode(gm);
		// MarketingAccount_LeandingPage:
		comm.goToMarketingAccountSubmodule();
		comm.createButton();
		// marketingCreatePage:
		MarketingAccountCreateAccountPage marketingCreatePage = new MarketingAccountCreateAccountPage(gm);
		String accountName = "rajaBhai";
		marketingCreatePage.fillAccountInformationDeatils(accountName);
		comm.topSaveButton();
		// AccountInformationPage:
		MarketingAccountInformationPage marketinginformations = new MarketingAccountInformationPage(gm);
		marketinginformations.goToMarketingAccountSubmodule();
		comm.checkDataStoreorNot("Account Name", accountName);
		System.out.println("verifyVT001CreateAccounts TestCase Completed");
	}

//updata_data:	
	@Test(priority = 2, groups = { "Smoke"})
	public void verifyVT002UpdateAccounts() throws Exception {
		System.out.println("verifyVT002UpdateAccounts TestCase Started");
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
		System.out.println("verifyVT002UpdateAccounts TestCase Completed");
		
	}

//Search_Data:	
	@Test(priority = 3, groups = {"Smoke"},dependsOnMethods = { "verifyVT002UpdateAccounts" })
	public void verifyVT003SearchAccounts() throws Exception {
		System.out.println("verifyVT003SearchAccounts TestCase Started");
		comm = new CommonReusableCode(gm);
//MarketingAccount_LeandingPage:	
		comm.goToMarketingAccountSubmodule();
		String text = "Bhairaja";
		comm.searchTextBox(text);
		String baseOption = "Account Name";
		comm.selectOptionsVisibleText(baseOption);
		comm.searchNowButton();
		comm.checkSearchOptionBaseData(baseOption, text);
		System.out.println("verifyVT003SearchAccounts TestCase Completed");

	}

//Delete_Data:
	@Test(priority = 4,groups = {"Smoke"})
	public void verifyVT004DeleteAccount() throws InterruptedException {
		System.out.println("verifyVT004DeleteAccounts TestCase Started");
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

		System.out.println("verifyVT004DeleteAccounts TestCase Completed");
		
	}

}
