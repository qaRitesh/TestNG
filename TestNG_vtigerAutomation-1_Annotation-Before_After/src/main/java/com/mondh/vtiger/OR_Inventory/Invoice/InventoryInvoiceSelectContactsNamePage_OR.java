package com.mondh.vtiger.OR_Inventory.Invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

import lombok.Getter;



public class InventoryInvoiceSelectContactsNamePage_OR extends CommonReusableCode {

	public InventoryInvoiceSelectContactsNamePage_OR(WebUtil wD) {
		super(wD);
		PageFactory.initElements(wD.getDriver(),this);
	}
	
	@Getter
	@CacheLookup
	@FindBy(xpath="//a[text()='Yadav Munna']")
	private WebElement selectiteam;



	
	
	
}