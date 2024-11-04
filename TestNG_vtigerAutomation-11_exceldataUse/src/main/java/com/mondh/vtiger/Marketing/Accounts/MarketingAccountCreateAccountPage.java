package com.mondh.vtiger.Marketing.Accounts;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.OR_Marketing.Accounts.MarketingAccountCreateAccountPage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

import net.bytebuddy.utility.RandomString;

public class MarketingAccountCreateAccountPage extends MarketingAccountCreateAccountPage_OR {

	private WebUtil gm;

	public MarketingAccountCreateAccountPage(WebUtil wD) {
		super(wD);
		this.gm = wD;
	}

	public void fillAccountInformationDeatils(String accountName, String website, String tickersymbol, String fax,
			String email, String phone) throws InterruptedException {
		String randomName = RandomString.make(5);

		gm.inputData(getAccountNameTB(), accountName);
		gm.inputData(getWebsiteTB(), website);
		gm.inputData(getTickersymbolTB(), tickersymbol);
		gm.inputData(getFaxTB(), fax);
		gm.inputData(getEmail(), accountName + email);
		gm.inputData(getPhoneTB(), phone);
		Thread.sleep(3000);
	}

	public void enterAddressInformation() {

	}

	public void enterDescriptionnformation() {

	}

	public void updateAccountName(String accName) {
		gm.inputData(getAccountNameTB(), accName);
	}

}
