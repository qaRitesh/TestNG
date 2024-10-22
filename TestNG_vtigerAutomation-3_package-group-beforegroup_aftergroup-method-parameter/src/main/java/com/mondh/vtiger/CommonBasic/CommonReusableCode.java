package com.mondh.vtiger.CommonBasic;

import java.util.List;

import com.mondh.vtiger.OR_CommonBasic.CommonOR;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class CommonReusableCode extends CommonOR {
	// Applications dependent methods
	// it uses generic methods to automate reusable functionality
//THE EXTEND COMMONCLASS  IN EACH PAGE CLASS.

	private WebUtil gm;

	public CommonReusableCode(WebUtil wD) {
		super(wD);
		this.gm = wD;
	}

//vtiger Login_Page:	
	public void velidLogin(String username,String password) {
		gm.inputData(getUserNameTB(), username);
		gm.inputData(getPasswordTB(), password);
		gm.clickButton(getLoginBT());
	}

	public void inVelidLogin() {
		gm.inputData(getUserNameTB(), "admin");
		gm.inputData(getPasswordTB(), "admin");
		gm.clickButton(getLoginBT());
	}

//pulseCreateButton:	
	public void createButton() {
		gm.clickButton(getCreateBT());

	}

//SalesModule:	
	public void goToSalesLeadsSubmodule() {
		gm.mousemoverToElement(getSalesMouseOver());
		gm.clickButton(getGoSalesLeadsSubmodule());
	}

	public void goToSalesAcountSubmodule() {
		gm.mousemoverToElement(getSalesMouseOver());
		gm.clickButton(getGoSalesAccountSubmodule());
	}

	public void goToSalesContactsSubmodule() {
		gm.mousemoverToElement(getSalesMouseOver());
		gm.clickButton(getGoSalesContactsSubmodule());
	}

//Marketing_Modules:
	public void goToMarketingCompaignsSubmodule() {
		gm.mousemoverToElement(getMarketingMouseOver());
		gm.clickButton(getGoMarketingCompaignsSubmodule());
	}

	public void goToMarketingAccountSubmodule() throws InterruptedException {
		Thread.sleep(3000);
		gm.mousemoverToElement(getMarketingMouseOver());
		gm.clickButton(getGoMarketingAccountSubmodule());
	}

	public void goToMarketingContactsSubmodule() {
		gm.mousemoverToElement(getMarketingMouseOver());
		gm.clickButton(getGomarketingContactsSubmodule());
	}

//Inventory_Modules:	
	public void goToInventoryProductsSubmodule() {
		gm.mousemoverToElement(getInventoryMouseOver());
		gm.clickButton(getGoInventoryProductsSubmodule());
	}

	public void goToInventoryInvoiceSubmodule() {
		gm.mousemoverToElement(getInventoryMouseOver());
		gm.clickButton(getGoInventoryInvoiceSubmodule());
	}

// SearchTextBox:
	public void searchTextBox(String searchtext) {
		gm.inputData(getSearchTB(), searchtext);
	}

// searchNowButton:
	public void searchNowButton() {
		gm.clickButton(getSearchNowBT());
	}

// selectoptionvisibaleText
	public void selectOptionsVisibleText(String OptionText) {
		gm.selectByVisibleText(getSelectvisibleText(), OptionText);
	}

//clicksaveButton:
	public void topSaveButton() {
		gm.clickButton(getSavceTopBT());
	}

//clickCancelButton:
	public void topCancelButton() {
		gm.clickButton(getCancleTopBT());
	}

//driverSignOuts:	
	public void userSignOut() {
		gm.clickButton(getSighOut());
	}

//checkDataStore:
	public void checkDataStoreorNot(String columnbas, String data) {
		List<String> tableData = gm.getColumnDataListByColumnName("//table[@class='lvt small']", columnbas);
		int num = 0;
		for (int i = 0; i <= tableData.size() - 1; i++) {
			String accname = tableData.get(i);
			if (accname.equalsIgnoreCase(data) == true) {
				num = 1;
				break;
			}
		}
		if (num == 1) {
			System.out.println("Pass Data store: " + data);
		} else {
			System.out.println("Fail Data  not store: " + data);
		}
	}

//update_match:
	public void checkUpdateData(String columnbas, String oldData, String newData) {
		List<String> tablecolumnList = gm.getColumnDataListByColumnName("//table[@class='lvt small']", columnbas);
		int num = 0;
		for (int i = 0; i <= tablecolumnList.size() - 1; i++) {
			String we = tablecolumnList.get(i);
			if (we.equalsIgnoreCase(newData)) {
				num = 1;
				break;
			}
		}
		if (num == 1) {
			System.out.println("Old your Data: " + oldData);
			System.out.println("New Upadte Data: " + newData);
		} else {
			System.out.println("Fail Data not Update: " + newData);
		}
		
	}
	
//SearchOptionbase_findItemcheck:
	public void checkSearchOptionBaseData(String basoption,String searchtext) {
		List<String> tablecolumnList =gm. getColumnDataListByColumnName("//table[@class='lvt small']", basoption);
		int num=0;
		for (int i = 0; i <= tablecolumnList.size() - 1; i++) {
			String we = tablecolumnList.get(i);
			if (we.equalsIgnoreCase(searchtext)) {
				num=1;
				break;
			}
		}
		if(num==1) {
			System.out.println("Searching Data find: "+searchtext);
		}else {
			System.out.println("Searching Data not find: "+searchtext);
		}
	}

//Delete_Data:
	public void checkDeleteDataOrNot(String columnName,String deleteText) {
		List<String> lastNameList = gm.getColumnDataListByColumnName("//table[@class='lvt small']", columnName);
		int num=0;
		for (int i = 0; i <= lastNameList.size() - 1; i++) {
			String we = lastNameList.get(i);
			if (we.equalsIgnoreCase(deleteText)) {		
				num=1;
				break;
			}
		}
		if(num==0) {
			System.out.println("Data are Delete: "+deleteText);
		}else {
			System.out.println("Data not Delete: "+deleteText);
		}
	}
}
