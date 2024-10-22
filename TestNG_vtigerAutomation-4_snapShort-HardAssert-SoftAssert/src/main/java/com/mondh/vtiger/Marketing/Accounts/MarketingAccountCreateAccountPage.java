package com.mondh.vtiger.Marketing.Accounts;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.OR_Marketing.Accounts.MarketingAccountCreateAccountPage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

import net.bytebuddy.utility.RandomString;

public class MarketingAccountCreateAccountPage extends MarketingAccountCreateAccountPage_OR{

	private WebUtil gm;
	
	public MarketingAccountCreateAccountPage(WebUtil wD) {
		super(wD);
		this.gm=wD;
	}

	
	public void fillAccountInformationDeatils(String acName) throws InterruptedException{
		String randomName=RandomString.make(5);
		
		gm.inputData(getAccountNameTB(),acName);
		gm.inputData(getWebsiteTB(), "www.mondh.com");
		gm.inputData(getTickersymbolTB(),"123456");
		gm.inputData(getFaxTB(), "dj");
		gm.inputData(getEmail(),"Email@12.com");
		gm.inputData(getPhoneTB(), "4568452290");
		Thread.sleep(3000);
	}
	
	public void enterAddressInformation() {
		
	}
	
	public void enterDescriptionnformation() {
		
	}
	
	public void updateAccountName(String accName) {
		gm.inputData(getAccountNameTB(),accName);
	}
	
	
}
