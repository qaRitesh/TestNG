package com.mondh.vtiger.Inventory.Invoice;


import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.OR_Inventory.Invoice.InventoryInvoiceSelectContactsNamePage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class InventoryInvoiceSelectContactsNamePage extends InventoryInvoiceSelectContactsNamePage_OR{

	private WebUtil gm;
	
	public InventoryInvoiceSelectContactsNamePage(WebUtil wD) {
		super(wD);
		this.gm=wD;
	}


	private String moveContactwindow="http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView";
	
		CommonReusableCode comm= new CommonReusableCode(gm);
	
	
	public void contactSearchAndAdd() {
		
		gm.getswitchTowindowByUrl(moveContactwindow);
		comm.searchTextBox("Munna");
		comm.selectOptionsVisibleText("First Name");
		comm.searchNowButton();
		gm.clickButton(getSelectiteam());
		gm.AlertAccepted();
	}
	
	
}
