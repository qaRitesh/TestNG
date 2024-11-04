package com.mondh.vtiger.TestScript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mondh.vtiger.genericyCodes.IRetryAnalyzreTestCase;


public class ListenerBase {

	@Test(retryAnalyzer = IRetryAnalyzreTestCase.class)
	public void method1() {
		System.out.println("method1");
	}
	@Test
	public void method2() {
		System.out.println("method2");
	}
}
