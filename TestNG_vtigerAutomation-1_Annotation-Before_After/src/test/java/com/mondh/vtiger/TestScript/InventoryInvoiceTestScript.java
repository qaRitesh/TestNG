package com.mondh.vtiger.TestScript;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.Inventory.Invoice.InventoryInvoiceCreateInvoicePage;
import com.mondh.vtiger.Inventory.Products.InventoryProductsCreatePage;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountCreateAccountPage;
import com.mondh.vtiger.Marketing.Contacts.MarketingContactCreateContactsPage;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class InventoryInvoiceTestScript {

	
	
	public void verifyVT001AccountAndContactOninvoicePage() throws InterruptedException {
		WebUtil gm=new WebUtil();
		
		System.out.println("verifyVT001AccountAndContactOninvoicePage TestCase Started");

		gm.lunchbrower();
		gm.openUrl("http://localhost:8888");
		gm.impliCityTimewait(5000);
		
		CommonReusableCode	comm=new CommonReusableCode(gm);	
		comm.velidLogin();
		
//marketing Accounts:		
		comm.goToMarketingAccountSubmodule();
		comm.createButton();		
		MarketingAccountCreateAccountPage marketingCreatePage = new MarketingAccountCreateAccountPage(gm);
		String accountName="rajaBhai";
		marketingCreatePage.fillAccountInformationDeatils(accountName);
		comm.topSaveButton();
		Thread.sleep(5000);
//Marketing Contacts:
		comm.goToMarketingContactsSubmodule();
		comm.createButton();	
		MarketingContactCreateContactsPage marketingCreateContact=new MarketingContactCreateContactsPage(gm);
		marketingCreateContact.enterAndSaveCreateContactPage();
		Thread.sleep(5000);
		
//inventory products:
		comm.goToInventoryProductsSubmodule();
		comm.createButton();
		InventoryProductsCreatePage inventoryProductsCreate=new InventoryProductsCreatePage(gm);
		inventoryProductsCreate.productInformation();
				
		
//Inventory Invoice:
			comm.goToInventoryInvoiceSubmodule();
			comm.createButton();	
		InventoryInvoiceCreateInvoicePage inventorycreate= new InventoryInvoiceCreateInvoicePage(gm);
		inventorycreate.invoiceInformation();
		inventorycreate.addresssInfirmation();	
		inventorycreate.itemDetails();
		
		comm.topSaveButton();
	
		System.out.println("verifyVT001AccountAndContactOninvoicePage TestCase Completed");		
		comm.userSignOut();
		gm.driverQuit();
		
		
	
		
		}
	
	
	
	
}
